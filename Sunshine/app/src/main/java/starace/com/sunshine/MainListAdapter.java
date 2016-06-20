package starace.com.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mstarace on 6/14/16.
 */
public class MainListAdapter extends ArrayAdapter<MainListItem> {
    private Context context;


    public MainListAdapter(Context context, int resource, List<MainListItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_view_container,null);

        TextView days = (TextView) listView.findViewById(R.id.day_name);
        TextView lows = (TextView) listView.findViewById(R.id.day_low_temp);
        TextView highs = (TextView) listView.findViewById(R.id.day_high_temp);

        days.setText(getItem(position).getDay());
        lows.setText(getItem(position).getLow());
        highs.setText(getItem(position).getHigh());

        return listView;
    }

}
