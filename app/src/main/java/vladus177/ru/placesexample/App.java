package vladus177.ru.placesexample;

import android.support.v7.app.AppCompatDelegate;

import vladus177.ru.placesexample.core.BaseApplication;
import vladus177.ru.placesexample.di.AppComponent;
import vladus177.ru.placesexample.di.AppModule;
import vladus177.ru.placesexample.di.DaggerAppComponent;

public class App extends BaseApplication {

    private static AppComponent appComponent;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static AppComponent getApplicationComponent() {
        return appComponent;
    }

    @Override
    protected void onPrepareApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onInjectApplication() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }
}
