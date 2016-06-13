package starace.com.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public static class MainActivityFragment extends Fragment {
        public MainActivityFragment(){

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View mainFragmentView = inflater.inflate(R.layout.fragment_main,null);
            ArrayList<String> days = createFakeWeatherData("high");

            return mainFragmentView;
        }

        private ArrayList<String> createFakeWeatherData(String type){
            ArrayList<String> toReturn = new ArrayList<>();
            switch (type) {
                case "high":
                    toReturn.add("90 F");
                    toReturn.add("95 F");
                    toReturn.add("92 F");
                    toReturn.add("87 F");
                    toReturn.add("86 F");
                    toReturn.add("90 F");
                    toReturn.add("91 F");
                    break;
                case "low":
                    toReturn.add("79 F");
                    toReturn.add("78 F");
                    toReturn.add("77 F");
                    toReturn.add("74 F");
                    toReturn.add("72 F");
                    toReturn.add("80 F");
                    toReturn.add("79 F");
                    break;
                case "day":
                    toReturn.add("Monday");
                    toReturn.add("Tuesday");
                    toReturn.add("Wednesday");
                    toReturn.add("Thursday");
                    toReturn.add("Friday");
                    toReturn.add("Saturday");
                    toReturn.add("Sunday");
                    break;
                default:
                    break;
            }
            return toReturn;

        }


    }


}
