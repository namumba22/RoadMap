package com.my;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static class CityCMP implements Comparator<City> {
        public static CityCMP build(){
            return new CityCMP();
        }

        @Override
        public int compare(City o1, City o2) {
            return o1.name.compareTo(o2.name);
        }
    }

}
