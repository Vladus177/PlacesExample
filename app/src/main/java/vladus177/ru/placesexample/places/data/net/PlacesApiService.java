package vladus177.ru.placesexample.places.data.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;


public interface PlacesApiService {

    @GET("api/place/nearbysearch/json?")
    Observable<PlacesEntity> getPlacesEntities(@Query("location") String location, @Query("radius") int radius, @Query("type") String type, @Query("key") String key);

}
