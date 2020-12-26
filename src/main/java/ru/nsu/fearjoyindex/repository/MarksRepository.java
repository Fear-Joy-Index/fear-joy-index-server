package ru.nsu.fearjoyindex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nsu.fearjoyindex.entity.Location;
import ru.nsu.fearjoyindex.entity.Mark;

import java.util.List;

public interface MarksRepository extends MongoRepository<Mark, String> {
    Mark findByLocation(Location location);

    List<Mark> findAll();
}
