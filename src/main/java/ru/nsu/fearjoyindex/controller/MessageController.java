package ru.nsu.fearjoyindex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fearjoyindex.entity.MarksContainer;
import ru.nsu.fearjoyindex.entity.PersonalMark;
import ru.nsu.fearjoyindex.repository.LocationsRepository;
import ru.nsu.fearjoyindex.service.CollectionsService;

import java.util.ArrayList;

@RestController
public class MessageController {

    @Autowired
    CollectionsService collectionsService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    LocationsRepository locationsRepository;

    @RequestMapping(value = "/saveMark", method = RequestMethod.POST)
    public ResponseEntity<String> saveMark(@RequestBody PersonalMark personalMark) {
        collectionsService.updateLocationMark(personalMark);
        return new ResponseEntity<>("Mark saved", HttpStatus.OK);
    }

    @RequestMapping(value = "/getMarks", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<MarksContainer>> getMarks() {
        return new ResponseEntity<>(collectionsService.wrapMarks(), HttpStatus.OK);
    }
}
