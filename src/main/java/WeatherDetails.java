import java.time.LocalDateTime;

public class WeatherDetails {
    public LocalDateTime responseDate;
    public String responseStatus;
    public String responseBody;

    public WeatherDetails() {

    }

    public WeatherDetails(LocalDateTime responseDate, String responseStatus, String responseBody) {
        this.responseDate = responseDate;
        this.responseStatus = responseStatus;
        this.responseBody = responseBody;
    }
}
