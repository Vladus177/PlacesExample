package vladus177.ru.placesexample.places.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import vladus177.ru.placesexample.common.view.LoadingDialogFragment;
import vladus177.ru.placesexample.places.data.repository.datasource.factory.PlacesDataSourceFactory;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesMapper;
import vladus177.ru.placesexample.places.data.repository.PlacesApiRepository;
import vladus177.ru.placesexample.places.domain.usecase.GetPlacesUseCase;
import vladus177.ru.placesexample.places.view.presenter.PlacesListPresenter;

@Module
public class PlacesModule {

    private AppCompatActivity activity;

    public PlacesModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    PlacesApiRepository providePlacesRepository(PlacesDataSourceFactory dataSourceFactory, PlacesMapper placesMapper) {
        return new PlacesApiRepository(dataSourceFactory, placesMapper);
    }

    @Provides
    PlacesDataSourceFactory providePlacesDataSourceFactory(Context context) {
        return new PlacesDataSourceFactory(context);
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
