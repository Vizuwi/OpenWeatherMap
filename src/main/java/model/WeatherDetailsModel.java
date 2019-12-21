package model;

import org.json.JSONObject;

import java.time.LocalDateTime;

public class WeatherDetailsModel {
    private LocalDateTime responseDate;
    private String responseStatus;
    private JSONObject responseBody;

    public WeatherDetailsModel() {

    }

    public WeatherDetailsModel(LocalDateTime responseDate, String responseStatus, JSONObject responseBody) {
        this.responseDate = responseDate;
        this.responseStatus = responseStatus;
        this.responseBody = responseBody;
    }

    public void setResponseBody(JSONObject responseBody) {
        this.responseBody = responseBody;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public JSONObject getResponseBody() {
        return responseBody;
    }

}
