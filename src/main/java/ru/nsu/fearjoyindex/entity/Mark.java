package ru.nsu.fearjoyindex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "marks")
public class Mark {
    @Id
    private int id;

    private double mark;
    private Date date;
    private int counter;
    private Location location;


    public Mark() {
        // requires public constructor
    }

    public Mark(double mark, Date date, int counter, Location location) {
        this.mark = mark;
        this.date = date;
        this.counter = counter;
        this.location = location;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
