package vladus177.ru.placesexample.places.data.net;

import java.util.List;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;

public interface PlacesRestApi {

    Observable<List<PlacesEntity>> getPlacesEntities();

}
