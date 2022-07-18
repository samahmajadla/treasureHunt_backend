package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.geo.Point;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("location_based")
@JsonTypeName("location")
public class LocationBasedSolution extends Solution{

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
       if (location.getX() == point.getX() && location.getY() == point.getY()){
           this.setSolution_found(true);
           return true;
       } else {


           return false;
       }
    }

}
