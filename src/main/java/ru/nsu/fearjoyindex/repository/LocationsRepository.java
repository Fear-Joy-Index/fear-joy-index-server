package ru.nsu.fearjoyindex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.fearjoyindex.entity.Location;

import java.util.List;

@Repository
public interface LocationsRepository extends MongoRepository<Location, String> {
    List<Location> findAll();
}
