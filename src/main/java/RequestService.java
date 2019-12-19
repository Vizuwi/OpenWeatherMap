import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class RequestService {

    String RESULT_UNITS = "metric";
    String KEY = "8c432e556320a52013e5c80ba00c0d0a";
    String CITY = "Minsk";
    String MODE = "json";

    public WeatherDetails getWeatherDetails() {

        WeatherDetails weatherDetail = new WeatherDetails();
        StringBuilder response = new StringBuilder();
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + CITY + "&appid=" + KEY + "&units=" + RESULT_UNITS + "&mode=" + MODE;

        try {

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setDoOutput(true);

            InputStream ip = con.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));

            String responseSingle = null;
            while ((responseSingle = br1.readLine()) != null) {
                response.append(responseSingle);
            }

            weatherDetail.responseBody = response.toString();
            weatherDetail.responseStatus = String.valueOf(con.getResponseCode());
            weatherDetail.responseDate = LocalDateTime.now();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return weatherDetail;
    }

}

