package vladus177.ru.placesexample.places.data.net;

import android.content.Context;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import vladus177.ru.placesexample.core.ApiClient;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;

public class PlacesRestApiImpl extends ApiClient<PlacesApiService> implements PlacesRestApi {

    private final Context context;
    private final PlacesApiService apiService;

    public PlacesRestApiImpl(Context context) {
        this.context = context;
        OkHttpClient client = initClient();
        apiService = initApi(client);
    }

    public static final String GOOGLE_PLACE_API_KEY = "ADD_YOUR_API_KEY_HERE";

    private static String base_url = "https://maps.googleapis.com/maps/";

    @Override
    public Observable<PlacesEntity> getPlacesEntities(PlacesRequestEntity requestEntity) {
        return apiService.getPlacesEntities(requestEntity.location, requestEntity.radius, requestEntity.type, requestEntity.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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
