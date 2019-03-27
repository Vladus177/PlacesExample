package vladus177.ru.placesexample.places.data.repository;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;

public interface GetPlacesRepository {

    Observable<PlacesModel> getPlacesList(String string);

    Observable<PlaceDetailModel> getPlaceDetail(String string);

    Observable<PlacePhotoModel> getPlacePhoto(String string);
}
