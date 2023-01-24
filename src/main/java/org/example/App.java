package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Logistics logistics = context.getBean(Logistics.class);
        System.out.println(Arrays.stream(logistics.getVehicles()).toList());
    }
}
