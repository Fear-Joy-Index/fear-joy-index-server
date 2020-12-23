//package ru.nsu.fearjoyindex.config;
//
//import com.mongodb.*;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Configuration
//public class MongoConfig {
//
//    public MongoClient mongo() {
//        MongoClientURI uri = new MongoClientURI(
//                "mongodb+srv://test_admin:Lt2zHpHsi0vvYrMR@cluster0.fnh1e.mongodb.net/joyIndex?retryWrites=true&w=majority&ssl=true");
//
//        MongoClient mongoClient = new MongoClient(uri);
//        MongoDatabase database = mongoClient.getDatabase("joyIndex");
//        return mongoClient;
////        final ConnectionString connectionString = new ConnectionString("mongodb+srv://test_admin:Lt2zHpHsi0vvYrMR@cluster0.fnh1e.mongodb.net/joyIndex?retryWrites=true&w=majority");
////        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
////        return MongoClients.create(mongoClientSettings);
//    }
//
////    @Bean
////    public MongoTemplate mongoTemplate() throws Exception {
////        return new MongoTemplate(mongo(), "ощнШтвуч");
////    }
//}
