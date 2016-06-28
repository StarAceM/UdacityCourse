package starace.com.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.sunshine.models.ForecastDay;
import starace.com.sunshine.models.RootWeatherObject;

public class MainActivity extends AppCompatActivity {
    private static final String ApiKey = "8e530f03adc24da917719b4396a58e4a";
    private static final String TAG_MAIN = "MainActivity";
    private static final String TAG_FRAGMENT = "MainActivityFragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityFragment mainFragment = new MainActivityFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_actvity_fragment_container,mainFragment).commit();

    }


    public static class MainActivityFragment extends Fragment {
        private ArrayList<MainListItem> mainListItems;
        private MainListAdapter mainAdapter;

        public MainActivityFragment(){

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View mainFragmentView = inflater.inflate(R.layout.fragment_main, null);
            mainListItems = new ArrayList<>();
            mainAdapter = new MainListAdapter(getActivity(),R.layout.main_list_view_container,mainListItems);
            ListView mainListView = (ListView) mainFragmentView.findViewById(R.id.main_list_view_for_container);
            mainListView.setAdapter(mainAdapter);
            createWeatherData();

            return mainFragmentView;
        }

        private void createWeatherData(){


//            toReturn.add(new MainListItem("Monday","90F","78F"));
//            toReturn.add(new MainListItem("Tuesday","91F","79F"));
//            toReturn.add(new MainListItem("Wednesday","92F","80F"));
//            toReturn.add(new MainListItem("Thursday","93F","81F"));
//            toReturn.add(new MainListItem("Friday","94F","82F"));
//            toReturn.add(new MainListItem("Saturday","95F","83F"));
//            toReturn.add(new MainListItem("Sunday","96F","84F"));

            WeatherClient weatherClient = RetrofitWeatherService.createService(WeatherClient.class);
            Call<RootWeatherObject> call = weatherClient.getForcast("94604","json","metric",7,ApiKey);
            call.enqueue(new Callback<RootWeatherObject>() {
                @Override
                public void onResponse(Call<RootWeatherObject> call, Response<RootWeatherObject> response) {
                    Log.d(TAG_FRAGMENT, "On Response has been call Retrofit Call");
                    if (response.isSuccessful()) {
                        RootWeatherObject rootObject = response.body();
                        ForecastDay[] forecastDays = rootObject.getList();
                        List<String> highs = new ArrayList<>();
                        List<String> lows = new ArrayList<>();
                        for (ForecastDay curDay : forecastDays) {
                            highs.add(curDay.getTemp().getMax());
                            lows.add(curDay.getTemp().getMin());
                        }

                        mainListItems.add(new MainListItem("Monday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Tuesday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Wednesday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Thursday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Friday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Saturday", highs.get(0), lows.get(0)));
                        mainListItems.add(new MainListItem("Sunday", highs.get(0), lows.get(0)));

                        updateAdapter();

                    } else {
                        Log.d(TAG_FRAGMENT, "Response not succesful " + response.message() + " " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<RootWeatherObject> call, Throwable t) {
                    Log.d(TAG_FRAGMENT, "On Failure has been call Retrofit Call");
                }
            });

        }

        public void updateAdapter(){

            mainAdapter.notifyDataSetChanged();
        }


    }


}
