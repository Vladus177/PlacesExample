package vladus177.ru.placesexample.places.view.presenter;

import android.content.Context;
import android.os.Build;


import java.util.ArrayList;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.BasePresenter;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesMapper;
import vladus177.ru.placesexample.places.domain.usecase.GetPlacesUseCase;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesListPresenter extends BasePresenter<PlacesListContract.View> implements PlacesListContract.Presenter {

    private GetPlacesUseCase getPlacesUseCase;
    private PlacesMapper placesMapper;
    private Context context;
    private ArrayList<PlacesView> placesList = new ArrayList<>();

    @Inject
    public PlacesListPresenter(GetPlacesUseCase getPlacesUseCase, PlacesMapper placesMapper, Context context) {
        this.getPlacesUseCase = getPlacesUseCase;
        this.placesMapper = placesMapper;
        this.context = context;
    }

    @Override
    public void getPlacesFromRemoteRepository() {

    }

    @Override
    public void getPlaceDetail() {

    }

    @Override
    public void getPlacePhoto() {

    }

    @Override
    public void checkLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !getView().locationPermissionsGranted()) {
            getView().askForLocationPermission();
        }
    }
}
