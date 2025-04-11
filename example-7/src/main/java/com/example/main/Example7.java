package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle>volkswagenSupplier = () -> volkswagen;
        Supplier<Vehicle>audiSupplier=()->{
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber: " + randomNumber);
        if(randomNumber%2==0)
        {
          context.registerBean("Volkswagen",Vehicle.class,volkswagenSupplier);
        }else{
            context.registerBean("audi",Vehicle.class,audiSupplier);
        }
        Vehicle volksvehicle=null;
        Vehicle audivehicle=null;
        try{
              volksvehicle=context.getBean("Volkswagen",Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating volkswagen vehicle");
        }
        try
        {
            audivehicle=context.getBean("audi",Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating audi vehicle");
        }
        if(volksvehicle!=null)
        {
            System.out.println("Programming Vehicle name from Spring context is : "+volksvehicle.getName());
        }
        if(audivehicle!=null)
        {
            System.out.println("Programming Vehicle name from Spring context is : "+audivehicle.getName());
        }
    }
}
