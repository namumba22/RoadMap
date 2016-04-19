package com.my;

import com.my.spring.RoadService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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


    private final static String CK = "Ck";

    @Test
    public void testGo() throws Exception {
        City city = roadService.addCity(CK,new City(). new Coordinate(1,2));

        assertEquals(CK,city.getName());
//        assertEquals(CK,roadService.getCityByName(CK).getName());




        assertNotNull("road service is null",roadService);
        assertNotNull("road service is null",applicationContext);
    }



}