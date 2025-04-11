package com.example.main;

import com.example.config.ProjectConfig;
import com.example.model.Song;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Example17 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleService = context.getBean(VehicleServices.class);
        System.out.println(vehicleService.getClass());
        Song song=new Song();
        song.setTitle("Black space");
        song.setSingerName("Taylor Swift");
        boolean vehicleStarted=true;
        String moveVehicleStatus=vehicleService.moveVehicle(vehicleStarted);
        String playMusicStatus=vehicleService.playMusic(vehicleStarted,song);
        String applyBreakStatus=vehicleService.applyBreak(vehicleStarted);

    }
}
