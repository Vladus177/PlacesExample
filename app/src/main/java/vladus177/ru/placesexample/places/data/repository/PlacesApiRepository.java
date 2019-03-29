package vladus177.ru.placesexample.places.data.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.PlacesRequestEntity;
import vladus177.ru.placesexample.places.data.repository.datasource.PlacesDataSource;
import vladus177.ru.placesexample.places.data.repository.datasource.factory.PlacesDataSourceFactory;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesMapper;
import vladus177.ru.placesexample.places.data.repository.datasource.mapper.PlacesRequestMapper;
import vladus177.ru.placesexample.places.domain.model.PlaceDetailModel;
import vladus177.ru.placesexample.places.domain.model.PlacePhotoModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesRequestParam;

public class PlacesApiRepository
        implements PlacesRepository {

    private PlacesMapper placesMapper;
    private PlacesDataSource dataSource;
    private PlacesRequestMapper placesRequestMapper;

    @Inject
    public PlacesApiRepository(PlacesDataSourceFactory dataSourceFactory, PlacesMapper placesMapper, PlacesRequestMapper placesRequestMapper ) {
        this.placesMapper = placesMapper;
        this.placesRequestMapper = placesRequestMapper;
        this.dataSource = dataSourceFactory.createDataSource();
    }

    @Override
    public Observable<PlacesModel> getPlacesEntities(PlacesRequestParam params) {
        return dataSource.getPlacesEntities(placesRequestMapper.map(params)).map(placesEntities -> placesMapper.reverseMap(placesEntities));
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
