package starace.com.sunshine.models;

/**
 * Created by mstarace on 6/20/16.
 */
public class ForecastDay {
    private Temp temp;
    private Weather[] weather;

    public Temp getTemp() {
        return temp;
    }

    public Weather[] getWeather() {
        return weather;
    }
}
