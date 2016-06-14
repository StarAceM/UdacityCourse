package starace.com.sunshine;

/**
 * Created by mstarace on 6/14/16.
 */
public class MainListItem {
    private String day;
    private String low;
    private String high;

    public MainListItem(String day, String high, String low) {
        this.day = day;
        this.high = high;
        this.low = low;
    }

    public String getDay() {
        return day;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }
}
