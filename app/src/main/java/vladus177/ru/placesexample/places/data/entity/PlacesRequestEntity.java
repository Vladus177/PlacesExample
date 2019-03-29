package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_KEY;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_LOCATION;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_RADIUS;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_TYPE;

public class PlacesRequestEntity {

    @SerializedName(PARAM_LOCATION)
    public String location;
    @SerializedName(PARAM_RADIUS)
    public int radius;
    @SerializedName(PARAM_TYPE)
    public String type;
    @SerializedName(PARAM_KEY)
    public String key;

}
