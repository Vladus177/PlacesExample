package vladus177.ru.placesexample.places.data.net;


import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;

public interface PlacesRestApi {

    Observable<PlacesEntity> getPlacesEntities(PlacesRequestEntity requestEntity);

}
