package ru.nsu.fearjoyindex.entity;

import com.mongodb.client.model.geojson.Position;

import java.sql.Timestamp;

public class PersonalMark {

    private Position coords;
    private Timestamp timestamp;
    private int emotion;

    public PersonalMark() {
    }

    public PersonalMark(Position coords, Timestamp timestamp, int emotion) {
        this.coords = coords;
        this.timestamp = timestamp;
        this.emotion = emotion;
    }

    public Position getLocation() {
        return coords;
    }

    public void setLocation(Position coords) {
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
