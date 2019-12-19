import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ResponseService {

    public void putWeatherDetails(WeatherDetails weatherDetails) {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase dbs = mongoClient.getDatabase("WeatherData");
            MongoCollection<Document> collection = dbs.getCollection("openweathermap");

            System.out.println("Documents count: before " + collection.count());

            Document doc = new Document("response_date", weatherDetails.responseDate)
                    .append("response_status", weatherDetails.responseStatus)
                    .append("response_body", weatherDetails.responseBody);
            collection.insertOne(doc);

            System.out.println("Documents count: after " + collection.count());

        } catch (Exception e) {
            System.out.println("error");
        }

    }
}
