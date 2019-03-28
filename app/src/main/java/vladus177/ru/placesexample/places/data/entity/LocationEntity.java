package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_LAT;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_LNG;

public class LocationEntity {
    @SerializedName(PARAM_LAT)
    public String lat;
    @SerializedName(PARAM_LNG)
    public String lng;
}
