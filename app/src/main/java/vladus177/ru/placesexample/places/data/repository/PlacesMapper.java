package vladus177.ru.placesexample.places.data.repository;

import java.util.ArrayList;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.Mapper;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesMapper
        extends Mapper<PlacesView, PlacesModel> {

    @Inject
    public PlacesMapper() {

    }

    @Override
    public PlacesModel map(PlacesView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PlacesView reverseMap(PlacesModel value) {
        PlacesView viewModel = new PlacesView();

        return viewModel;
    }
}
