package starace.com.sunshine;

/**
 * Created by mstarace on 6/20/16.
 */
public class RootWeatherObject {
    private City city;
    private WeatherList[] list;

    public RootWeatherObject(City city, WeatherList[] list) {
        this.city = city;
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public WeatherList[] getList() {
        return list;
    }
}
