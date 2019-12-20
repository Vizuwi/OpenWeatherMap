package scheduler;

import model.WeatherDetailsModel;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import service.PropertiesService;
import service.RequestService;
import service.ResponseService;

public class WeatherReport implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        RequestService requestService = new RequestService();
        ResponseService responseService = new ResponseService();
        PropertiesService propertiesService = new PropertiesService();

        String url = propertiesService.getUrlWithProperties();
        WeatherDetailsModel weatherDetails = requestService.getWeatherDetails(url);
        responseService.putWeatherDetails(weatherDetails);
    }
}
