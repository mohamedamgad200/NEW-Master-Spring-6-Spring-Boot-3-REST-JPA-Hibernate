package com.example.config;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.example.services","com.example.implementation","com.example.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
