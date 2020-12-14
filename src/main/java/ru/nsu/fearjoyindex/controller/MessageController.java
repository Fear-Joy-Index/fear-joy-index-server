package ru.nsu.fearjoyindex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fearjoyindex.entity.Mark;
import ru.nsu.fearjoyindex.repository.MarksRepository;

@RestController
public class MessageController {

    @Autowired
    MarksRepository marksRepository;

    @RequestMapping(value = "/saveMark", method = RequestMethod.POST)
    public ResponseEntity<String> saveMark(Mark mark) {

        return new ResponseEntity<>("Mark saved", HttpStatus.OK);
    }

}
