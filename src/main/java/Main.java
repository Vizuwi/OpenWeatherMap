import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import scheduler.WeatherReport;
import service.PropertiesService;


import static org.quartz.CronScheduleBuilder.cronSchedule;

public class Main {
    public static void main(String[] args) throws SchedulerException {

        PropertiesService propertiesService = new PropertiesService();
        String cronSchedule = propertiesService.getCronSchedule();

        JobDetail jobDetail = JobBuilder.newJob(WeatherReport.class).build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule(cronSchedule))
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);

    }
}
