package ru.nsu.fearjoyindex.entity;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private String type;

    private List<List<Double>> coordinates;

    public Polygon(String type, List<List<Double>> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Point2D.Double> toPointsList() {
        ArrayList<Point2D.Double> points = new ArrayList<>();
        coordinates.forEach((point) -> {
            Double x = point.get(0);
            Double y = point.get(1);
            points.add(new Point2D.Double(x, y));
        });
        return points;
    }
}
