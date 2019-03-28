package vladus177.ru.placesexample.places.data.repository.datasource.factory;

import android.content.Context;

import javax.inject.Inject;

import vladus177.ru.placesexample.places.data.net.PlacesRestApiImpl;
import vladus177.ru.placesexample.places.data.repository.datasource.PlacesApiDataSource;

public class PlacesDataSourceFactory {

    private final Context context;

    @Inject
    public PlacesDataSourceFactory(Context context) {
        this.context = context;
    }

    public PlacesApiDataSource createDataSource() {
        PlacesRestApiImpl restApi =
                new PlacesRestApiImpl(context);
        return new PlacesApiDataSource(restApi);
    }
}
