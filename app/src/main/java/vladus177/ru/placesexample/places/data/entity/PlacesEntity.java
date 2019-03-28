package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_GEOMETRY;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_NEXT_PAGE_TOKEN;


public class PlacesEntity {

    @SerializedName(PARAM_NEXT_PAGE_TOKEN)
    public String nextPageToken;
    @SerializedName(PARAM_GEOMETRY)
    public GeometryEntity geometry;
}
