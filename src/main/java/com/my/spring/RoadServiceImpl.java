package com.my.spring;

import com.my.City;
import com.my.Road;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.*;

import static org.junit.Assert.assertEquals;

// (@Component, @Repository, @Service, and @Controller)

@NotThreadSafe
@Scope("prototype")
@Component
public class RoadServiceImpl implements RoadService {

//    @Autowired
//    private Set<Road> fullfillWays;

    @Resource(name = "str")
    private List str;

    @Resource(name = "roads")
    private Set<Road> roads;

    @Resource(name = "cities")
    private Set<City> cities;

    @Override
    public City addCity(String name, City.Coordinate coordinate) {
        City city = new City(name);
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
        City template = new City(name);
        List<City> cityList = new ArrayList<>();
        cityList.addAll(cities);
        Collections.sort(cityList,City.aComparator);

        int position = Collections.binarySearch(cityList,template,City.aComparator);

        City retVal=null;
        if(position >= 0 ){
            retVal = cityList.get(position);
        }
        return retVal;
    }

    @Override
    public Set<Road> getRoadsByCityName(String name) {

        Set<Road> retVal = new HashSet<>();

        Road template = new Road();
        template.setFrom(new City(name));
        template.setTo(new City(name));
        fullfillWays(retVal, template,Road.comparatorFrom);
        fullfillWays(retVal, template,Road.comparatorTo);

        return retVal;
    }

    private Set<Road> fullfillWays(Set<Road> retVal, Road template, Comparator<Road> comparator) {
        List<Road> roadList = new LinkedList<>();
        roadList.addAll(roads);
        Collections.sort(roadList,comparator);

        int position = -10;

        while ( ( position = Collections.binarySearch(roadList,template,comparator) )>=0 ){
            if(position >= 0 ){
                retVal.add( roadList.get(position) );
                roadList.remove(position);
            }
        }
        return retVal;
    }

}
