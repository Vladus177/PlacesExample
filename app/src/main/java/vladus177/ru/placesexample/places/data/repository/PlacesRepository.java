package vladus177.ru.placesexample.places.data.repository;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;

public class PlacesRepository
        implements GetPlacesRepository {

    @Inject
    public PlacesRepository(Context context) {
        this.context = context;
    }

    private Context context;

    @Override
    public Observable<PlacesModel> getPlacesList(String string) {
        return null;
    }

    @Override
    public Observable<PlaceDetailModel> getPlaceDetail(String string) {
        return null;
    }

    @Override
    public Observable<PlacePhotoModel> getPlacePhoto(String string) {
        return null;
    }
}
