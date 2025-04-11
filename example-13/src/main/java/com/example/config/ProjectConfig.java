package com.example.config;
import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.example.services","com.example.implementation"})
@ComponentScan(basePackageClasses = {com.example.beans.Person.class, com.example.beans.Vehicle.class})
public class ProjectConfig {
}
