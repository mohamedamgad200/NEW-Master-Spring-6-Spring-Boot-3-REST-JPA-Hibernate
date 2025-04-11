package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyresBean implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle moving with BridgeStone tyres";
    }
}
