package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_GEOMETRY;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_ICON;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_ID;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_NAME;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_OPENING_HOURS;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_PLACE_ID;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_PRICE_LEVEL;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_RATING;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_USER_RATING_TOTAL;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_VICINITY;

public class ResultEntity {

    @SerializedName(PARAM_GEOMETRY)
    public GeometryEntity geometry;

    @SerializedName(PARAM_ICON)
    public String icon;

    @SerializedName(PARAM_ID)
    public String id;

    @SerializedName(PARAM_NAME)
    public String name;

    @SerializedName(PARAM_OPENING_HOURS)
    public OpeningHoursEntity openingHours;

    @SerializedName(PARAM_PLACE_ID)
    public String placeId;

    @SerializedName(PARAM_RATING)
    public float rating;

    @SerializedName(PARAM_USER_RATING_TOTAL)
    public int ratingTotal;

    @SerializedName(PARAM_PRICE_LEVEL)
    public int priceLevel;

    @SerializedName(PARAM_VICINITY)
    public String vicinity;

}
