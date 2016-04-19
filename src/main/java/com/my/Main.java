package com.my;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dumin on 4/18/16.
 */
public class Main {
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
    }

//    MyService myService = ctx.getBean(MyService.class);
//    myService.doStuff();
}
