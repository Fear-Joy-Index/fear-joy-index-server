package ru.nsu.fearjoyindex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nsu.fearjoyindex.entity.Mark;

public interface MarksRepository extends MongoRepository<Mark, String> {

}
