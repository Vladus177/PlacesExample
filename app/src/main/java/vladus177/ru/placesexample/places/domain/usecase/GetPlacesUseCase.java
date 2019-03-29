package vladus177.ru.placesexample.places.domain.usecase;


import javax.inject.Inject;

import io.reactivex.Observable;
import vladus177.ru.placesexample.core.UseCaseParameters;
import vladus177.ru.placesexample.places.data.repository.PlacesRepository;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestParam;

public class GetPlacesUseCase
        extends UseCaseParameters<PlacesModel, PlacesRequestParam> {
    private final PlacesRepository repository;

    @Inject
    public GetPlacesUseCase(PlacesRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<PlacesModel> buildUseCase(PlacesRequestParam params) {
        return repository.getPlacesEntities(params);
    }

}
