package ru.nsu.fearjoyindex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class Location {
    @Id
    private String _id;

    private String type;

    private Polygon geometry;

    public Location() {
        // requires public constructor
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Polygon getGeometry() {
        return this.geometry;
    }

    public void setGeometry(Polygon geometry) {
        this.geometry = geometry;
    }
}
