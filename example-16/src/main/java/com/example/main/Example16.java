package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Example16 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleService1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2=context.getBean("vehicleServices",VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 is "+vehicleService1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 is "+vehicleServices2.hashCode());
        if(vehicleService1==vehicleServices2) {
            System.out.println("vehicleService bean is a singleton scoped bean");
        }
        else{
            System.out.println("vehicleService bean is not a prototype scoped bean");
        }
    }
}
