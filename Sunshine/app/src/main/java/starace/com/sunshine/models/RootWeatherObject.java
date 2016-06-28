package starace.com.sunshine.models;

/**
 * Created by mstarace on 6/20/16.
 */
public class RootWeatherObject {
    private City city;
    private ForecastDay[] list;

    public RootWeatherObject(City city, ForecastDay[] list) {
        this.city = city;
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public ForecastDay[] getList() {
        return list;
    }
}
