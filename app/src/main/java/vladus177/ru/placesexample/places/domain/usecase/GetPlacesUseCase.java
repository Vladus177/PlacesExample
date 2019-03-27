package vladus177.ru.placesexample.places.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import vladus177.ru.placesexample.core.UseCaseParameters;
import vladus177.ru.placesexample.places.data.repository.PlacesRepository;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestModel;

public class GetPlacesUseCase
        extends UseCaseParameters<PlacesModel, PlacesRequestModel> {
    private final PlacesRepository placesRepository;

    @Inject
    public GetPlacesUseCase(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }


    @Override
    protected Observable<PlacesModel> buildUseCase(PlacesRequestModel requestModel) {
        return placesRepository.getPlacesList(requestModel.key);
    }

    @Override
    public void execute(DisposableObserver<PlacesModel> disposableObserver, PlacesRequestModel parameters) {
        super.execute(disposableObserver, parameters);
    }
}
