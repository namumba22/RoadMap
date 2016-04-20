package com.my;

import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;

public class Road {

    private String name;
    private City from;
    private City to;

    public Road(String name, City from, City to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(name, road.name);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static class RoadCMP implements Comparator<Road>{
        public static RoadCMP build(){
            return new RoadCMP();
        }

        @Override
        public int compare(Road o1, Road o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
