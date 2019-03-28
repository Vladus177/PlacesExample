package vladus177.ru.placesexample.places.data.repository.datasource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.net.PlacesRestApi;

public class PlacesApiDataSource implements PlacesDataSource {

    private final PlacesRestApi placesRestApi;

    @Inject
    public PlacesApiDataSource(PlacesRestApi placesRestApi) {
        this.placesRestApi = placesRestApi;
    }

    @Override
    public Observable<List<PlacesEntity>> getPlacesEntities() {
        return placesRestApi.getPlacesEntities();
    }
}
