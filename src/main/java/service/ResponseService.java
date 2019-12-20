package service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.DataBaseModel;
import model.WeatherDetailsModel;
import org.bson.Document;

public class ResponseService {

    public void putWeatherDetails(WeatherDetailsModel weatherDetails) {

        PropertiesService propertiesService = new PropertiesService();
        DataBaseModel dbModel = propertiesService.getDBProperties();

        try {
            MongoClient mongoClient = new MongoClient(dbModel.getHost(), dbModel.getPort());
            MongoDatabase dbs = mongoClient.getDatabase(dbModel.getDatabase());
            MongoCollection<Document> collection = dbs.getCollection(dbModel.getCollection());

            System.out.println("Documents count: before " + collection.count());

            Document doc = new Document("response_date", weatherDetails.getResponseDate())
                    .append("response_status", weatherDetails.getResponseStatus())
                    .append("response_body", weatherDetails.getResponseBody());
            collection.insertOne(doc);

            System.out.println("Documents count: after " + collection.count());

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
