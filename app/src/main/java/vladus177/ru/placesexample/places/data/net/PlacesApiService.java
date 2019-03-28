package vladus177.ru.placesexample.places.data.net;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;

public interface PlacesApiService {

    @GET("place/nearbysearch/json?")
    Observable<List<PlacesEntity>> getPlacesEntities();

}
