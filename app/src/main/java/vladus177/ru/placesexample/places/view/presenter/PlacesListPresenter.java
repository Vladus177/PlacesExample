package vladus177.ru.placesexample.places.view.presenter;

import android.content.Context;
import android.os.Build;

import javax.inject.Inject;

import vladus177.ru.placesexample.common.util.LocationConverter;
import vladus177.ru.placesexample.core.BasePresenter;
import vladus177.ru.placesexample.core.UseCaseObserver;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestParam;
import vladus177.ru.placesexample.places.domain.usecase.GetPlacesUseCase;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;
import vladus177.ru.placesexample.places.view.viewmodel.mapper.PlacesModelToViewMapper;

import static vladus177.ru.placesexample.places.constants.Constant.TYPE_RESTAURANT;

public class PlacesListPresenter extends BasePresenter<PlacesListContract.View> implements PlacesListContract.Presenter {

    private GetPlacesUseCase getPlacesUseCase;
    private PlacesModelToViewMapper placesModelToViewMapper;
    private Context context;
    private String location;
    private String nextPageToken;
    private String type = TYPE_RESTAURANT;
    private int PROXIMITY_RADIUS = 1500;


    @Inject
    public PlacesListPresenter(GetPlacesUseCase getPlacesUseCase, PlacesModelToViewMapper placesModelToViewMapper, Context context) {
        this.getPlacesUseCase = getPlacesUseCase;
        this.placesModelToViewMapper = placesModelToViewMapper;
        this.context = context;
    }

    @Override
    public void getPlaceDetail() {

    }

    @Override
    public void getPlacePhoto() {

    }

    @Override
    public void setUserLocationAndRequestPlaces(double lat, double lng) {
        location = LocationConverter.getLocation(lat, lng);
        if (!location.isEmpty()) {
            PlacesRequestParam params = new PlacesRequestParam();
            params.location = location;
            params.radius = PROXIMITY_RADIUS;
            params.type = type;
            getPlacesUseCase.execute(new PlacesListObserver(), params);
        } else {
            getView().showInformation("Please check your location service");
        }
    }

    @Override
    public boolean checkLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !getView().locationPermissionsGranted()) {
            getView().askForLocationPermission();
            return false;
        } else {
            return true;
        }
    }

    private class PlacesListObserver extends UseCaseObserver<PlacesModel> {
        @Override
        protected void onStart() {
            getView().showLoading();
        }

        @Override
        public void onNext(PlacesModel placesModels) {
            PlacesView placesViews = placesModelToViewMapper.reverseMap(placesModels);
            getView().setPlaces(placesViews);
        }

        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().showError("Connection Error");
        }

        @Override
        public void onComplete() {
            getView().hideLoading();
        }
    }
}
