package vladus177.ru.placesexample.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import vladus177.ru.placesexample.App;

@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent {
    Application getApplication();

    Context getContext();

    void inject(App app);
}
