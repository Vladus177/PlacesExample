package vladus177.ru.placesexample.places.data.repository.datasource;


import javax.inject.Inject;

import io.reactivex.Observable;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;
import vladus177.ru.placesexample.places.data.net.PlacesRestApi;

public class PlacesApiDataSource implements PlacesDataSource {

    private final PlacesRestApi placesRestApi;

    @Inject
    public PlacesApiDataSource(PlacesRestApi placesRestApi) {
        this.placesRestApi = placesRestApi;
    }

    @Override
    public Observable<PlacesEntity> getPlacesEntities(PlacesRequestEntity requestEntity) {
        return placesRestApi.getPlacesEntities(requestEntity);
    }
}
