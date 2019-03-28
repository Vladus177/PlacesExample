package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_LOCATION;

public class GeometryEntity {

    @SerializedName(PARAM_LOCATION)
    public LocationEntity location;
}
