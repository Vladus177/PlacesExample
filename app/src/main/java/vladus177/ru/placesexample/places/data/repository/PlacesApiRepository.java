package vladus177.ru.placesexample.places.data.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.repository.datasource.PlacesDataSource;
import vladus177.ru.placesexample.places.data.repository.datasource.factory.PlacesDataSourceFactory;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesMapper;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;

public class PlacesApiRepository
        implements PlacesRepository {

    private PlacesMapper placesMapper;
    private PlacesDataSource dataSource;

    public PlacesApiRepository(PlacesDataSourceFactory dataSourceFactory, PlacesMapper placesMapper) {
        this.placesMapper = placesMapper;
        this.dataSource = dataSourceFactory.createDataSource();
    }

    @Override
    public Observable<List<PlacesModel>> getPlacesEntities(String string) {
        return dataSource.getPlacesEntities()
                .map(new Function<List<PlacesEntity>, List<PlacesModel>>() {
                    @Override
                    public List<PlacesModel> apply(List<PlacesEntity> placesEntities) throws Exception {
                        return placesMapper.reverseMap(placesEntities);
                    }
                });
    }

    @Override
    public Observable<PlaceDetailModel> getPlaceDetail(String string) {
        return null;
    }

    @Override
    public Observable<PlacePhotoModel> getPlacePhoto(String string) {
        return null;
    }
}
