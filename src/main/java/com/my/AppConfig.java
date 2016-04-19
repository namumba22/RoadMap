package com.my;

import com.my.spring.RoadService;
import com.my.spring.RoadServiceImpl;

//@Configuration
public class AppConfig {
//    @Bean
    public RoadService roadService() {
        return new RoadServiceImpl();
    }
}