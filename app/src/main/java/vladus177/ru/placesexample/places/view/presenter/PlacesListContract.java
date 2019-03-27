package vladus177.ru.placesexample.places.view.presenter;


import java.util.ArrayList;

import vladus177.ru.placesexample.core.BasePresenter;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public interface PlacesListContract {
    interface View extends BasePresenter.View {

        void setPlaces(ArrayList<PlacesView> places);

        void askForLocationPermission();

        boolean locationPermissionsGranted();
    }

    interface Presenter {

        void getPlacesFromRemoteRepository();

        void getPlaceDetail();

        void getPlacePhoto();

        void checkLocationPermission();

    }
}
