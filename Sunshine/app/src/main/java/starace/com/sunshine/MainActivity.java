package starace.com.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityFragment mainFragment = new MainActivityFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_actvity_fragment_container,mainFragment).commit();

    }


    public static class MainActivityFragment extends Fragment {
        public MainActivityFragment(){

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View mainFragmentView = inflater.inflate(R.layout.fragment_main, null);
            ArrayList<MainListItem> mainListItems = createFakeWeatherData();
            MainListAdapter mainAdapter = new MainListAdapter(getActivity(),R.layout.main_list_view_container,mainListItems);
            ListView mainListView = (ListView) mainFragmentView.findViewById(R.id.main_list_view_for_container);
            mainListView.setAdapter(mainAdapter);


            return mainFragmentView;
        }

        private ArrayList<MainListItem> createFakeWeatherData(){
            ArrayList<MainListItem> toReturn = new ArrayList<>();

            toReturn.add(new MainListItem("Monday","90F","78F"));
            toReturn.add(new MainListItem("Tuesday","91F","79F"));
            toReturn.add(new MainListItem("Wednesday","92F","80F"));
            toReturn.add(new MainListItem("Thursday","93F","81F"));
            toReturn.add(new MainListItem("Friday","94F","82F"));
            toReturn.add(new MainListItem("Saturday","95F","83F"));
            toReturn.add(new MainListItem("Sunday","96F","84F"));

            return toReturn;

        }


    }


}
