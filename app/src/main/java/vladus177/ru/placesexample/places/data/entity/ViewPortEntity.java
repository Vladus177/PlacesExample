package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_NORTHEAST;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_SOUTHEAST;

public class ViewPortEntity {

    @SerializedName(PARAM_NORTHEAST)
    public LocationEntity northeast;

    @SerializedName(PARAM_SOUTHEAST)
    public LocationEntity southeast;

}
