package vladus177.ru.placesexample.places.data.repository.datasource.mapper;

import javax.inject.Inject;

import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestParam;

public class PlacesRequestMapper {
    @Inject
    public PlacesRequestMapper() {
    }

    public PlacesRequestEntity map(PlacesRequestParam params) {
        PlacesRequestEntity entity = new PlacesRequestEntity();
        entity.location = params.location;
        entity.radius = params.radius;
        entity.type = params.type;
        entity.key = params.key;


        return entity;
    }
}
