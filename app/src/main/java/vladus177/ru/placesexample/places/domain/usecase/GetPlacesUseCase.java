package vladus177.ru.placesexample.places.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import vladus177.ru.placesexample.core.UseCaseParameters;
import vladus177.ru.placesexample.places.data.repository.PlacesApiRepository;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestModel;

public class GetPlacesUseCase
        extends UseCaseParameters<List<PlacesModel>, PlacesRequestModel> {
    private final PlacesApiRepository placesApiRepository;

    @Inject
    public GetPlacesUseCase(PlacesApiRepository placesApiRepository) {
        this.placesApiRepository = placesApiRepository;
    }

    @Override
    protected Observable<List<PlacesModel>> buildUseCase(PlacesRequestModel requestModel) {
        return placesApiRepository.getPlacesEntities(requestModel.key);
    }

}
