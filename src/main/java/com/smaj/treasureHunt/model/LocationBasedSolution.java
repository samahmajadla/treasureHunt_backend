package com.smaj.treasureHunt.model;

import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.geo.Point;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("location_based")
public class LocationBasedSolution extends Solution{

    private Point location;

    @Override
    public boolean checkSolution(String answer) {
        return false;
    }

}
