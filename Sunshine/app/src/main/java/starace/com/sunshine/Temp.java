package starace.com.sunshine;

/**
 * Created by mstarace on 6/20/16.
 */
public class Temp {
    private String min;
    private String max;

    public Temp(String max, String min) {
        this.max = max;
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public String getMin() {
        return min;
    }
}
