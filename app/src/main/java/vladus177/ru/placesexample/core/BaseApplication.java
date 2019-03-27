package vladus177.ru.placesexample.core;

import android.app.Application;

public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        onInjectApplication();
        onPrepareApplication();
    }

    protected abstract void onPrepareApplication();

    protected abstract void onInjectApplication();
}
