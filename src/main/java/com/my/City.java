package com.my;

import java.io.IOException;

public class City {

    private String name;

    private Coordinate coordinate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }



    public class Coordinate{
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        private int x;
        private int y;
    }


}
