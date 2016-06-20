package starace.com.sunshine;

/**
 * Created by mstarace on 6/20/16.
 */
public class Weather {
    private String main;
    private String description;

    public Weather(String description, String main) {
        this.description = description;
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }
}
