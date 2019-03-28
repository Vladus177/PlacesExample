package vladus177.ru.placesexample.places.data.repository.datasource;

import java.util.List;


import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;

public interface PlacesDataSource {

    Observable<List<PlacesEntity>> getPlacesEntities();
}
