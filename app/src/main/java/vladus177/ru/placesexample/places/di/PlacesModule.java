package vladus177.ru.placesexample.places.di;

import android.content.Context;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


import dagger.Module;
import dagger.Provides;
import vladus177.ru.placesexample.common.view.LoadingDialogFragment;
import vladus177.ru.placesexample.places.data.repository.PlacesRepository;
import vladus177.ru.placesexample.places.data.repository.datasource.factory.PlacesDataSourceFactory;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesMapper;
import vladus177.ru.placesexample.places.data.repository.PlacesApiRepository;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesRequestMapper;
import vladus177.ru.placesexample.places.domain.usecase.GetPlacesUseCase;
import vladus177.ru.placesexample.places.view.presenter.PlacesListPresenter;
import vladus177.ru.placesexample.places.view.viewmodel.mapper.PlacesModelToViewMapper;

@Module
public class PlacesModule {

    @Provides
    PlacesRepository providePlacesRepository(PlacesDataSourceFactory dataSourceFactory, PlacesMapper placesMapper, PlacesRequestMapper placesRequestMapper) {
        return new PlacesApiRepository(dataSourceFactory, placesMapper, placesRequestMapper);
    }

    @Provides
    PlacesDataSourceFactory providePlacesDataSourceFactory(Context context) {
        return new PlacesDataSourceFactory(context);
    }

    @Provides
    PlacesListPresenter providePlacesPresenter(GetPlacesUseCase getPlacesUseCase, PlacesModelToViewMapper placesModelToViewMapper, Context context) {
        return new PlacesListPresenter(getPlacesUseCase, placesModelToViewMapper, context);
    }

    @Provides
    FusedLocationProviderClient provideLocationListener(Context context) {
        return LocationServices.getFusedLocationProviderClient(context);

    }

    @Provides
    GoogleApiClient provideGoogleApiClient(Context context) {
        return new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .build();
    }

    @Provides
    LocationRequest provideLocationRequest() {
        return new LocationRequest();
    }

    @Provides
    LoadingDialogFragment provideLoadingDialogFragment() {
        return new LoadingDialogFragment();
    }
}
