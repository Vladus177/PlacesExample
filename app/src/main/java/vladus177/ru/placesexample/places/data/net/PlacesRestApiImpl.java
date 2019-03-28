package vladus177.ru.placesexample.places.data.net;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import vladus177.ru.placesexample.core.ApiClient;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;

public class PlacesRestApiImpl extends ApiClient<PlacesApiService> implements PlacesRestApi {

    private final Context context;
    private final PlacesApiService apiService;

    public PlacesRestApiImpl(Context context) {
        this.context = context;
        OkHttpClient client = initClient();
        apiService = initApi(client);
    }

    public static final String GOOGLE_PLACE_API_KEY = "ADD_YOUR_API_KEY_HERE";

    public static String base_url = "https://maps.googleapis.com/maps/api/";

    @Override
    public Observable<List<PlacesEntity>> getPlacesEntities() {
        return apiService.getPlacesEntities();
    }

    @Override
    protected Context getContext() {
        return context;
    }

    @Override
    protected String getBaseUrl() {
        return base_url;
    }

    @Override
    protected Class<PlacesApiService> getApiService() {
        return PlacesApiService.class;
    }
}
