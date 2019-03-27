package vladus177.ru.placesexample.places.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import vladus177.ru.placesexample.common.view.LoadingDialogFragment;
import vladus177.ru.placesexample.places.data.repository.PlacesMapper;
import vladus177.ru.placesexample.places.data.repository.PlacesRepository;
import vladus177.ru.placesexample.places.domain.usecase.GetPlacesUseCase;
import vladus177.ru.placesexample.places.view.presenter.PlacesListPresenter;

@Module
public class PlacesModule {

    @Provides
    PlacesRepository providePlacesRepository(Context context) {
        return new PlacesRepository(context);
    }

    @Provides
    PlacesListPresenter providePlacesPresenter(GetPlacesUseCase getPlacesUseCase, PlacesMapper placesMapper, Context context) {
        return new PlacesListPresenter(getPlacesUseCase, placesMapper, context);
    }

    @Provides
    LoadingDialogFragment provideLoadingDialogFragment() {
        return new LoadingDialogFragment();
    }
}
