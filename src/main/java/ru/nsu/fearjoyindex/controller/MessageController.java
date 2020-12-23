package ru.nsu.fearjoyindex.controller;

import com.mongodb.client.model.geojson.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fearjoyindex.entity.PersonalMark;
import ru.nsu.fearjoyindex.repository.MarksRepository;

import java.sql.Timestamp;

@RestController
public class MessageController {

    @Autowired
    MarksRepository marksRepository;

    @RequestMapping(value = "/saveMark", method = RequestMethod.POST)
    public ResponseEntity<String> saveMark(@RequestBody PersonalMark personalMark) {
        updateLocationMark(personalMark);
        return new ResponseEntity<>("Mark saved", HttpStatus.OK);
    }

    private void updateLocationMark(PersonalMark personalMark) {
        Position userCoords = personalMark.getLocation();


    }



}
