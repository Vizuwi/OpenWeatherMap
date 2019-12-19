package service;

import model.WeatherDetailsModel;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class RequestService {

    public WeatherDetailsModel getWeatherDetails(String urlString) {

        WeatherDetailsModel weatherDetail = new WeatherDetailsModel();
        StringBuilder response = new StringBuilder();

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

            weatherDetail.setResponseBody(response.toString());
            weatherDetail.setResponseStatus(String.valueOf(con.getResponseCode()));
            weatherDetail.setResponseDate(LocalDateTime.now());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return weatherDetail;
    }

}

