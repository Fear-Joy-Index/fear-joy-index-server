package ru.nsu.fearjoyindex.entity;

import com.mongodb.client.model.geojson.Position;

import java.awt.geom.Point2D;
import java.sql.Timestamp;

public class PersonalMark {

    private Point2D.Double coords;
    private Timestamp timestamp;
    private int emotion;

    public PersonalMark() {
    }

    public PersonalMark(Point2D.Double coords, Timestamp timestamp, int emotion) {
        this.coords = coords;
        this.timestamp = timestamp;
        this.emotion = emotion;
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

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }
}
