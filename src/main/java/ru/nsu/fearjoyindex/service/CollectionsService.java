package ru.nsu.fearjoyindex.service;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.nsu.fearjoyindex.entity.Location;
import ru.nsu.fearjoyindex.entity.PersonalMark;

import java.util.List;

@Service
public class CollectionsService {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoTemplate mongoTemplate;

    public void updateLocationMark(PersonalMark personalMark) {
        GeoJsonPoint point = new GeoJsonPoint(new Point(personalMark.getCoords().getX(),
                                                        personalMark.getCoords().getY()));
        Query query = new Query().addCriteria(Criteria.where("locations").intersects(point));
        List<Location> list = mongoTemplate.find(query, Location.class);
        System.out.println(list.size());
    }

    public String getCollectionAsBson(String collection) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("joyindex");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
        MongoCursor<Document> iterator = mongoCollection.find().iterator();
        BasicDBList list = new BasicDBList();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            list.add(doc);
        }
        return new Gson().toJson(list);
    }
}
