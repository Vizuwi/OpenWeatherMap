package service;

import model.DataBaseModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {

    public String pathFile = "README.txt";

    public String getUrlWithProperties() {
        Properties properties = new Properties();
        String urlString;
        try {
            InputStream is = new FileInputStream(pathFile);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlString = properties.getProperty("urlapi") + properties.getProperty("city")
                + "&appid=" + properties.getProperty("key")
                + "&units=" + properties.getProperty("units")
                + "&mode=" + properties.getProperty("mode");
        return urlString;
    }

    public DataBaseModel getDBProperties() {
        DataBaseModel dbmodel = new DataBaseModel();
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(pathFile);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbmodel.setCollection(properties.getProperty("collection"));
        dbmodel.setDatabase(properties.getProperty("database"));
        dbmodel.setHost(properties.getProperty("host"));
        dbmodel.setPort(Integer.valueOf(properties.getProperty("port")));

        return dbmodel;
    }

    public String getCronSchedule (){

        String cronSchedule;
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(pathFile);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cronSchedule = properties.getProperty("cronSchedule");
        return cronSchedule;
    }
}
