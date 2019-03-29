package vladus177.ru.placesexample.places.data.repository;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestParam;

public interface PlacesRepository {

    Observable<PlacesModel> getPlacesEntities(PlacesRequestParam params);

    Observable<PlaceDetailModel> getPlaceDetail(String string);

    Observable<PlacePhotoModel> getPlacePhoto(String string);
}
