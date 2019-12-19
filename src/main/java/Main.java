
public class Main {
    public static void main(String[] args) {

        RequestService requestService = new RequestService();
        ResponseService responseService = new ResponseService();

        WeatherDetails weatherDetails = requestService.getWeatherDetails();
        responseService.putWeatherDetails(weatherDetails);

    }
}
