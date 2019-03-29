package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_LOCATION;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_VIEW_PORT;

public class GeometryEntity {

    @SerializedName(PARAM_LOCATION)
    public LocationEntity location;

    @SerializedName(PARAM_VIEW_PORT)
    public ViewPortEntity viewport;
}
