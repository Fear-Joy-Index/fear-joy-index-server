package ru.nsu.fearjoyindex.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import ru.nsu.fearjoyindex.entity.Location;
import ru.nsu.fearjoyindex.repository.LocationsRepository;

import java.util.ArrayList;

@Configuration
@EnableMongoRepositories(basePackages = "ru.nsu.fearjoyindex.repository")
public class MongoConfig {

    @Autowired
    LocationsRepository locationsRepository;

    @Component
    @ReadingConverter
    private class LocationIdConverter implements Converter<String, Location> {

        @Override
        public Location convert(String id) {
            return locationsRepository.findBy_id(id);
        }
    }

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://test_admin:Lt2zHpHsi0vvYrMR@cluster0.fnh1e.mongodb.net/joyIndex?retryWrites=true&w=majority"
        );
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongo(), "joyIndex");
    }

    @Bean
    public MappingMongoConverter customConversions() {
        SimpleMongoClientDatabaseFactory mongoDbFactory = mongoDbFactory();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
        ArrayList<Converter<?, ?>> convertersList = new ArrayList<>();
        convertersList.add(new LocationIdConverter());
        converter.setCustomConversions(new CustomConversions(convertersList));
        return converter;
    }
}
