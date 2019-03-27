package vladus177.ru.placesexample.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }

    @Provides
    Context providesContext() {
        return application;
    }

}
