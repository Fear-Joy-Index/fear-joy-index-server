package ru.nsu.fearjoyindex.entity;

import com.mongodb.client.model.geojson.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "locations")
public class Location {
    @Id
    private String id;

    private List<Point> location;

    public Location() {
        // requires public constructor
    }

    public Location(List<Point> location) {
        this.location = location;
    }

    public List<Point> getLocation() {
        return location;
    }

    public void setLocation(List<Point> location) {
        this.location = location;
    }
}
