package vladus177.ru.placesexample.places.view.viewmodel;

import java.util.List;

import vladus177.ru.placesexample.places.domain.model.PlacesResultModel;

public class PlacesView {
    public String nextPageToken;
    public List<PlacesResultView> results;
    public String status;
}
