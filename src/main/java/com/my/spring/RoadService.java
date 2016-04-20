package com.my.spring;

import com.my.City;
import com.my.Road;

import java.util.List;
import java.util.Set;

/**
 * Created by dumin on 4/19/16.
 */
public interface RoadService {

     String[] CK = {"Ck","Ck2","Ck3","Ck4","Ck5","Ck6","Ck7","Ck99"};

//    1.     Добавление нового города
City addCity(String name, City.Coordinate coordinate);
//    2.     Добавление новой дороги
Road addRoad(String name, City from, City to);
//    3.     Удаление дороги
void dropRoad(Road road);
//    4.     Получение города по имени
    City getCityByName(String name);
//    5.     Получение списка дорог по имени города
    Set<Road> getRoadsByCityName(String name);
}
