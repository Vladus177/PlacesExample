package vladus177.ru.placesexample.places.view.presenter;



import vladus177.ru.placesexample.core.BasePresenter;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public interface PlacesListContract {
    interface View extends BasePresenter.View {

        void setPlaces(PlacesView places);

        void askForLocationPermission();

        boolean locationPermissionsGranted();
    }

    interface Presenter {

        void getPlaceDetail();

        void getPlacePhoto();

        void setUserLocationAndRequestPlaces(double lat, double lng);

        boolean checkLocationPermission();

    }
}
