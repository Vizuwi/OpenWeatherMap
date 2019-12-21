package service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.DataBaseModel;
import model.WeatherDetailsModel;
import org.bson.Document;
import org.apache.log4j.Logger;


public class ResponseService {

    private static final Logger LOGGER2 = Logger.getLogger(ResponseService.class.getSimpleName());

    PropertiesService propertiesService = new PropertiesService();
    DataBaseModel dbModel = propertiesService.getDBProperties();

    MongoClient mongoClient = new MongoClient(dbModel.getHost(), dbModel.getPort());
    MongoDatabase dbs = mongoClient.getDatabase(dbModel.getDatabase());
    MongoCollection<Document> collection = dbs.getCollection(dbModel.getCollection());

    public void putWeatherDetails(WeatherDetailsModel weatherDetails) {

        LOGGER2.info("Start of Response");

        try {

            Document doc = new Document("response_date", weatherDetails.getResponseDate())
                    .append("response_status", weatherDetails.getResponseStatus())
                    .append("response_body", weatherDetails.getResponseBody().toString());
            collection.insertOne(doc);

            LOGGER2.info("Document was added. Documents in collection: " + collection.countDocuments());

        } catch (Exception e) {

            LOGGER2.error("Error! Document wasn't added.");

        }
    }
}
