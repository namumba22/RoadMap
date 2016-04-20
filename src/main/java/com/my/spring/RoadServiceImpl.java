package com.my.spring;

import com.my.City;
import com.my.Road;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.util.*;

// (@Component, @Repository, @Service, and @Controller)

@NotThreadSafe
@Scope("prototype")
@Component
public class RoadServiceImpl implements RoadService {

//    @Autowired
//    private Set<Road> roads;

    @Resource(name = "str")
    private List str;

    @Resource(name = "roads")
    private Set<Road> roads;

    @Resource(name = "cities")
    private Set<City> cities;

    @Override
    public City addCity(String name, City.Coordinate coordinate) {
        City city = new City();
        city.setName(name);
        city.setCoordinate(coordinate);
        cities.add(city);
        return city;
    }

    @Override
    public Road addRoad(String name, City from, City to) {
        Road road = new Road(name,from,to);
        roads.add(road);
        return road;
    }

    @Override
    public void dropRoad(Road road) {

    }

    @Override
    public City getCityByName(String name) {
        City template = new City();
        template.setName(name);
        List<City> ct = new ArrayList<>();
        ct.addAll(cities);
        int position = Collections.binarySearch(ct,template,City.CityCMP.build());

        City retVal=null;
        if(position !=0 ){
            retVal = ct.get(position);
        }


        return retVal;
    }

    @Override
    public Set<Road> getRoadsByName(String name) {

        List<Road> rd = new ArrayList<>();
        rd.addAll(roads);



//        Collections.binarySearch(rd,"",Road.RoadCMP.build());

        return null;
    }
}
