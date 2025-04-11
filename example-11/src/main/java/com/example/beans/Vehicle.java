package com.example.beans;
import org.springframework.stereotype.Component;
@Component
public class Vehicle {
    private String name="Toyota";

    public Vehicle() {
        System.out.println("Vehicle bean created by spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printHello() {
        System.out.println("Printing hello form component vehicle bean");
    }

    @Override
    public String toString() {
        return "Vehicle name is - "+name;
    }
}
