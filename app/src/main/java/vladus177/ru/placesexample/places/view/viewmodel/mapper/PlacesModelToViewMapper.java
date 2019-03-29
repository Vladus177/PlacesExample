package vladus177.ru.placesexample.places.view.viewmodel.mapper;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.Mapper;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesModelToViewMapper extends Mapper<PlacesView, PlacesModel> {

    @Inject
    public PlacesModelToViewMapper() {
    }

    @Override
    public PlacesModel map(PlacesView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PlacesView reverseMap(PlacesModel value) {
        PlacesView placesView = new PlacesView();
        return placesView;
    }
}
