package ru.nsu.fearjoyindex.entity;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MarksContainer {
    private ArrayList<Point2D.Double> coordinates;
    private double score;

    public MarksContainer(ArrayList<Point2D.Double> coordinates, double score) {
        this.coordinates = coordinates;
        this.score = score;
    }

    public ArrayList<Point2D.Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Point2D.Double> coordinates) {
        this.coordinates = coordinates;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
