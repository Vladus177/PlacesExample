package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_OPEN_NOW;

public class OpeningHoursEntity {
    @SerializedName(PARAM_OPEN_NOW)
    public boolean isOpenNow;
}
