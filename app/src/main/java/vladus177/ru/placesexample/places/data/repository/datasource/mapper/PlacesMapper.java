package vladus177.ru.placesexample.places.data.repository.datasource.mapper;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.Mapper;
import vladus177.ru.placesexample.places.data.entity.PlacesEntity;
import vladus177.ru.placesexample.places.data.entity.ResultEntity;
import vladus177.ru.placesexample.places.domain.model.GeometryModel;
import vladus177.ru.placesexample.places.domain.model.LocationModel;
import vladus177.ru.placesexample.places.domain.model.OpeningHoursModel;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesResultModel;
import vladus177.ru.placesexample.places.domain.model.ViewPortModel;

public class PlacesMapper
        extends Mapper<PlacesModel, PlacesEntity> {

    @Inject
    public PlacesMapper() {

    }

    @Override
    public PlacesEntity map(PlacesModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PlacesModel reverseMap(PlacesEntity value) {
        PlacesModel model = new PlacesModel();
        if (value.nextPageToken != null) {
            model.nextPageToken = value.nextPageToken;
        }
        if (value.results != null) {
            model.results = mapResultModel(value.results);
        }
        if (value.status != null) {
            model.status = value.status;
        }
        return model;
    }

    private List<PlacesResultModel> mapResultModel(List<ResultEntity> resultEntities) {
        List<PlacesResultModel> placesResultModels = new ArrayList<>();
        for (ResultEntity entity : resultEntities) {
            PlacesResultModel model = new PlacesResultModel();
            if (entity.geometry != null) {
                GeometryModel geometryModel = new GeometryModel();
                LocationModel locationModel = new LocationModel();
                ViewPortModel viewportModel = new ViewPortModel();
                LocationModel viewportNorthEastModel = new LocationModel();
                LocationModel viewportSouthEastModel = new LocationModel();

                locationModel.lat = entity.geometry.location.lat;
                locationModel.lng = entity.geometry.location.lng;

                viewportNorthEastModel.lat = entity.geometry.viewport.northeast.lat;
                viewportNorthEastModel.lng = entity.geometry.viewport.northeast.lng;
                viewportSouthEastModel.lat = entity.geometry.viewport.southeast.lat;
                viewportSouthEastModel.lng = entity.geometry.viewport.southeast.lng;

                viewportModel.northeast = viewportNorthEastModel;
                viewportModel.southeast = viewportSouthEastModel;

                geometryModel.location = locationModel;
                geometryModel.viewport = viewportModel;
                model.geometry = geometryModel;
            }
            if (entity.icon != null) {
                model.icon = entity.icon;
            }
            if (entity.id != null) {
                model.id = entity.id;
            }
            if (entity.name != null) {
                model.name = entity.name;
            }
            if (entity.openingHours != null) {
                OpeningHoursModel openingHoursModel = new OpeningHoursModel();
                openingHoursModel.isOpenNow = entity.openingHours.isOpenNow;
                model.openingHours = openingHoursModel;
            }
            if (entity.placeId != null) {
                model.placeId = entity.placeId;
            }
            model.rating = entity.rating;
            model.ratingTotal = entity.ratingTotal;
            model.priceLevel = entity.priceLevel;
            if (entity.vicinity != null) {
                model.vicinity = entity.vicinity;
            }
            placesResultModels.add(model);
        }
        return placesResultModels;
    }
}
