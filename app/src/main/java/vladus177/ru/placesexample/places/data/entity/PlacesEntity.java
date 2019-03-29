package vladus177.ru.placesexample.places.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_NEXT_PAGE_TOKEN;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_RESULTS;
import static vladus177.ru.placesexample.places.data.entity.constant.PlacesConstant.PARAM_STATUS;


public class PlacesEntity {

    @SerializedName(PARAM_NEXT_PAGE_TOKEN)
    public String nextPageToken;
    @SerializedName(PARAM_RESULTS)
    public List<ResultEntity> results;
    @SerializedName(PARAM_STATUS)
    public String status;

}
