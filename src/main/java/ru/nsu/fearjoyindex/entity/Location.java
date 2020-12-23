package ru.nsu.fearjoyindex.entity;

import com.mongodb.client.model.geojson.Polygon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class Location {
    @Id
    private String id;

    private Polygon polygon;

    public Location() {
        // requires public constructor
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
}
