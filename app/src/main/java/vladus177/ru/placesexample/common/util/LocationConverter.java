package vladus177.ru.placesexample.common.util;

public class LocationConverter {

    public static String getLocation(double lat, double lng) {
        try {
            String latitude = Double.toString(lat);
            String longitude = Double.toString(lng);
            return latitude + "," + longitude;
        } catch (Exception e) {
            return "";
        }
    }
}
