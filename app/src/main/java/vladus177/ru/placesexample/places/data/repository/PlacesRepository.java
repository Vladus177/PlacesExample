package vladus177.ru.placesexample.places.data.repository;

import java.util.List;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;

public interface PlacesRepository {

    Observable<List<PlacesModel>> getPlacesEntities(String string);

    Observable<PlaceDetailModel> getPlaceDetail(String string);

    Observable<PlacePhotoModel> getPlacePhoto(String string);
}
