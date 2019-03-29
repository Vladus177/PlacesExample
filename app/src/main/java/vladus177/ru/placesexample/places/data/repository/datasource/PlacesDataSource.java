package vladus177.ru.placesexample.places.data.repository.datasource;



import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;

public interface PlacesDataSource {

    Observable<PlacesEntity> getPlacesEntities(PlacesRequestEntity requestEntity);
}
