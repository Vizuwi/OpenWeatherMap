package service;

import model.WeatherDetailsModel;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

public class RequestService {

    private static final Logger LOGGER1 = Logger.getLogger(RequestService.class.getSimpleName());

    WeatherDetailsModel weatherDetail = new WeatherDetailsModel();
    StringBuilder response = new StringBuilder();

    public WeatherDetailsModel getWeatherDetails(String urlString) {

        LOGGER1.info("Start of request");

        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            InputStream ip = con.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));

            String responseSingle;
            while ((responseSingle = br1.readLine()) != null) {
                response.append(responseSingle);
            }

            weatherDetail.setResponseBody(response.toString());
            weatherDetail.setResponseStatus(String.valueOf(con.getResponseCode()));
            weatherDetail.setResponseDate(LocalDateTime.now());

            LOGGER1.info("Weather forecast was received");

        } catch (Exception e) {
            LOGGER1.error("Error! Weather forecast wasn't received");
        }

        return weatherDetail;
    }

}

