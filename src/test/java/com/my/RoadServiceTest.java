package com.my;

import com.my.spring.RoadService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by dumin on 4/18/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml"})
public class RoadServiceTest {

    @Autowired
    RoadService roadService;

    @Autowired
    private ApplicationContext applicationContext;
    @Resource(name = "cities")
    private Set<City> cities;

    @Resource(name = "roads")
    private Set<Road> roads;


    private final static String[] CK = {"Ck","Ck2","Ck3","Ck4","Ck5","Ck6","Ck7","Ck99"};
    private final static City.Coordinate coordinate =  new City(). new Coordinate(1,2);

    @Test
    public void testAddCity() throws Exception {
        int startSize = cities.size();
        City city = roadService.addCity(CK[0],coordinate);
        assertEquals(CK[0],city.getName());
        assertNotEquals(startSize, cities.size());

    }

    @Test
    public void testAddRoad() throws Exception {
        int startSize = roads.size();
        Road road = roadService.addRoad(CK[0],roadService.addCity(CK[1],coordinate),roadService.addCity(CK[2],coordinate));
        assertEquals(CK[0],road.getName());
        assertNotEquals(startSize, roads.size());
    }

    @Ignore
    @Test
    public void testSearchRoad() throws Exception {
        roadService.addRoad(CK[3],roadService.addCity(CK[4],coordinate),roadService.addCity(CK[5],coordinate));
        Set<Road> roadsByName = roadService.getRoadsByName(CK[0]);
        assertEquals(roadsByName.size(),2);
    }

    @Ignore
    @Test
    public void testSearchCity() throws Exception {
        assertNotNull(roadService.getCityByName(CK[0]));
        assertNull(roadService.getCityByName(CK[7]));
    }

}