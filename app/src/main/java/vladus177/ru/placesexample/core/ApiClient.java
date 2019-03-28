package vladus177.ru.placesexample.core;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.net.SocketFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiClient<T> {

    protected T initApi(OkHttpClient client) {

        return new Retrofit.Builder().baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(getApiService());
    }

    protected OkHttpClient initClient() {
        return initRetrofit();
    }

    private OkHttpClient initRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.socketFactory(SocketFactory.getDefault());
        okHttpBuilder.readTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);
        return okHttpBuilder.build();
    }

    protected String getBaseUrl() {
        return null;
    }

    protected Class<T> getApiService() {
        return null;
    }

    protected Context getContext() {
        return null;
    }
}
