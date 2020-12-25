package ru.nsu.fearjoyindex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fearjoyindex.entity.PersonalMark;
import ru.nsu.fearjoyindex.service.CollectionsService;

@RestController
public class MessageController {

    @Autowired
    CollectionsService collectionsService;

    @RequestMapping(value = "/saveMark", method = RequestMethod.POST)
    public ResponseEntity<String> saveMark(@RequestBody PersonalMark personalMark) {
        collectionsService.updateLocationMark(personalMark);
        return new ResponseEntity<>("Mark saved", HttpStatus.OK);
    }

    @RequestMapping(value = "/getMarks", method = RequestMethod.GET)
    public ResponseEntity<String> getMarks() {
        return new ResponseEntity<>(collectionsService.getCollectionAsBson("marks"), HttpStatus.OK);
    }

}
