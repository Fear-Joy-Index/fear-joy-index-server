package ru.nsu.fearjoyindex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.fearjoyindex.entity.Location;
import ru.nsu.fearjoyindex.entity.Mark;
import ru.nsu.fearjoyindex.entity.MarksContainer;
import ru.nsu.fearjoyindex.entity.PersonalMark;
import ru.nsu.fearjoyindex.repository.LocationsRepository;
import ru.nsu.fearjoyindex.repository.MarksRepository;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionsService {

    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    MarksRepository marksRepository;

    public double PI = 3.14159265;
    public double TWOPI = 2 * PI;


    private boolean isInside(double latitude, double longitude, ArrayList<Point2D.Double> points) {
        double angle = 0;
        double point1Lat, point1Long,
               point2Lat, point2Long;
        int n = points.size();

        for (int i = 0; i < n; i++) {
            point1Lat = points.get(i).getX() - latitude;
            point1Long = points.get(i).getY() - longitude;
            point2Lat = points.get((i+1)%n).getX() - latitude;
            point2Long = points.get((i+1)%n).getY() - longitude;
            angle += Angle2D(point1Lat, point1Long ,point2Lat, point2Long);
        }
        return !(Math.abs(angle) < PI);
    }

    public double Angle2D(double y1, double x1, double y2, double x2) {
        double theta1 = Math.atan2(y1,x1);
        double theta2 = Math.atan2(y2,x2);
        double dtheta = theta2 - theta1;
        while (dtheta > PI) {
            dtheta -= TWOPI;
        }
        while (dtheta < -PI) {
            dtheta += TWOPI;
        }
        return(dtheta);
    }

    public void updateLocationMark(PersonalMark personalMark) {
        List<Location> locs = locationsRepository.findAll();
        locs.forEach((loc -> {
            if (isInside(personalMark.getCoords().getX(), personalMark.getCoords().getY(),
                    loc.getGeometry().toPointsList())) {
                Mark mark = marksRepository.findByLocation(loc);
                double recalculatedMark = (mark.getMark() + personalMark.getMark()) / (mark.getCounter() + 1);
                mark.setMark(recalculatedMark);
                mark.setCounter(mark.getCounter() + 1);
                mark.setLocation(loc);
                marksRepository.save(mark);
            }
        }));
    }

    public ArrayList<MarksContainer> wrapMarks() {
        List<Mark> marks = marksRepository.findAll();
        ArrayList<MarksContainer> wrapped = new ArrayList<>();
        marks.forEach((mark) -> {
            ArrayList<Point2D.Double> points = mark.getLocation().getGeometry().toPointsList();
            MarksContainer newContainer = new MarksContainer(points, mark.getMark());
            wrapped.add(newContainer);
        });
        return wrapped;
    }
}
