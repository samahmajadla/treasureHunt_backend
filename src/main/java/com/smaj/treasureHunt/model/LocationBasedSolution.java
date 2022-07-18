package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.geo.Point;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("location_based")
@JsonTypeName("location")
public class LocationBasedSolution extends Solution {

    public LocationBasedSolution() {

    }

    private Point location;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public boolean checkSolution(Object guess) {
        Point point = (Point) guess;
        double actual_x = location.getX();
        double actual_y = location.getY();


        double guess_x = point.getX();
        double guess_y = point.getY();
        if (Math.abs(actual_x - guess_x) < 100) {
            if (Math.abs(actual_y - guess_y) < 100) {
                this.setSolution_found(true);
                return true;
            }
        }
        return false;
    }

}
