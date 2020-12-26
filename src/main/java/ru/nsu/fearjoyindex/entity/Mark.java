package ru.nsu.fearjoyindex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
public class Mark {
    @Id
    private String _id;

    private double mark;
    private String date;
    private int counter;
    private Location location;

    public Mark() {
    }

    public Mark(double mark, String date, int counter, Location location) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
