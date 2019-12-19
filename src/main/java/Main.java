import model.WeatherDetailsModel;
import service.PropertiesService;
import service.RequestService;
import service.ResponseService;

public class Main {
    public static void main(String[] args) {

        RequestService requestService = new RequestService();
        ResponseService responseService = new ResponseService();
        PropertiesService propertiesService = new PropertiesService();

        String url = propertiesService.getUrlWithProperties();
        WeatherDetailsModel weatherDetails = requestService.getWeatherDetails(url);
        responseService.putWeatherDetails(weatherDetails);

    }
}
