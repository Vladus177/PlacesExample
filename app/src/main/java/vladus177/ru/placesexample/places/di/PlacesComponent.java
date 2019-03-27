package vladus177.ru.placesexample.places.di;

import dagger.Component;
import vladus177.ru.placesexample.di.ActivityScope;
import vladus177.ru.placesexample.di.AppComponent;
import vladus177.ru.placesexample.places.view.fragment.PlacesListFragment;

@ActivityScope
@Component(modules = {
        PlacesModule.class},
        dependencies = AppComponent.class)
public interface PlacesComponent {

    void inject(PlacesListFragment fragment);

}