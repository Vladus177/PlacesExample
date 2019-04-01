package vladus177.ru.placesexample.places.view.viewmodel.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vladus177.ru.placesexample.core.Mapper;
import vladus177.ru.placesexample.places.data.entity.ResultEntity;
import vladus177.ru.placesexample.places.domain.model.PlacesModel;
import vladus177.ru.placesexample.places.domain.model.PlacesResultModel;
import vladus177.ru.placesexample.places.view.viewmodel.GeometryView;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesResultView;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesModelToViewMapper extends Mapper<PlacesView, PlacesModel> {

    @Inject
    public PlacesModelToViewMapper() {
    }

    @Override
    public PlacesModel map(PlacesView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PlacesView reverseMap(PlacesModel value) {
        PlacesView view = new PlacesView();


        if (value.nextPageToken != null) {
            view.nextPageToken = value.nextPageToken;
        }
        if (value.results != null) {
            view.results = mapResultView(value.results);
        }
        if (value.status != null) {
            view.status = value.status;
        }
        return view;
    }

    private List<PlacesResultView> mapResultView(List<PlacesResultModel> resultModels) {
        List<PlacesResultView> placesResultViews = new ArrayList<>();
        for (PlacesResultModel model : resultModels) {
            PlacesResultView view = new PlacesResultView();
            if (model.geometry != null) {
                GeometryView geometryView = new GeometryView();
                geometryView.locationLat = model.geometry.location.lat;
                geometryView.locationLng = model.geometry.location.lng;
                geometryView.northeastLat = model.geometry.viewport.northeast.lat;
                geometryView.northeastLng = model.geometry.viewport.northeast.lng;
                geometryView.southeastLat = model.geometry.viewport.southeast.lat;
                geometryView.southeastLng = model.geometry.viewport.southeast.lng;
                view.geometry = geometryView;
            }
            if (model.icon != null) {
                view.icon = model.icon;
            }
            if (model.id != null) {
                view.id = model.id;
            }
            if (model.name != null) {
                view.name = model.name;
            }
            if (model.openingHours != null) {
                view.isOpenNow = model.openingHours.isOpenNow;
            }
            if (model.placeId != null) {
                view.placeId = model.placeId;
            }
            view.rating = Float.toString(model.rating);
            view.ratingTotal = Integer.toString(model.ratingTotal);
            view.priceLevel = model.priceLevel;
            if (model.vicinity != null) {
                view.vicinity = model.vicinity;
            }
            placesResultViews.add(view);
        }
        return placesResultViews;
    }
}
