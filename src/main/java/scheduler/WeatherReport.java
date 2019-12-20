package scheduler;

import model.WeatherDetailsModel;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import service.PropertiesService;
import service.RequestService;
import service.ResponseService;

public class WeatherReport implements Job {

    private static final Logger LOGGER3 = Logger.getLogger(WeatherReport.class.getSimpleName());

    RequestService requestService = new RequestService();
    ResponseService responseService = new ResponseService();
    PropertiesService propertiesService = new PropertiesService();

    String url = propertiesService.getUrlWithProperties();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        LOGGER3.info("Start Task");

        WeatherDetailsModel weatherDetails = requestService.getWeatherDetails(url);
        responseService.putWeatherDetails(weatherDetails);

        LOGGER3.info("End Task");
    }
}
