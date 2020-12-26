package ru.nsu.fearjoyindex.entity;

import java.awt.geom.Point2D;
import java.sql.Timestamp;

public class PersonalMark {

    private Point2D.Double coords;
    private Timestamp timestamp;
    private int mark;

    public PersonalMark() {
    }

    public PersonalMark(Point2D.Double coords, Timestamp timestamp, int mark) {
        this.coords = coords;
        this.timestamp = timestamp;
        this.mark = mark;
    }

    public Point2D.Double getCoords() {
        return coords;
    }

    public void setCoords(Point2D.Double coords) {
        this.coords = coords;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
