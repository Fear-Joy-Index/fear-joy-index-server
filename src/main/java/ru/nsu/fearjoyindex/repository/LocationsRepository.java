package ru.nsu.fearjoyindex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nsu.fearjoyindex.entity.Location;

public interface LocationsRepository extends MongoRepository<Location, String> {

}
