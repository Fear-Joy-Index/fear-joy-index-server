package ru.nsu.fearjoyindex;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FearJoyIndexApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FearJoyIndexApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://test_admin:Lt2zHpHsi0vvYrMR@cluster0.fnh1e.mongodb.net/joyIndex?retryWrites=true&w=majority&ssl=true");

        com.mongodb.MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("joyIndex");
    }

}
