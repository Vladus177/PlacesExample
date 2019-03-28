package vladus177.ru.placesexample.places.data.repository.datasource.mapper;

import java.util.ArrayList;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.Mapper;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;

public class PlacesMapper
        extends Mapper<PlacesModel, PlacesEntity> {

    @Inject
    public PlacesMapper() {

    }

    @Override
    public PlacesEntity map(PlacesModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PlacesModel reverseMap(PlacesEntity value) {
        PlacesModel model = new PlacesModel();
        //TODO map it
        return model;
    }

}
