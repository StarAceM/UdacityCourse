package starace.com.sunshine;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import starace.com.sunshine.models.RootWeatherObject;

/**
 * Created by mstarace on 6/27/16.
 */
public interface WeatherClient {

    @GET("/data/2.5/forecast/daily")
    Call<RootWeatherObject> getForcast(
            @Query("q") String zipCode,
            @Query("mode") String json,
            @Query("units") String units,
            @Query("cnt") int numDays,
            @Query("APPID") String apiKey
    );
}
