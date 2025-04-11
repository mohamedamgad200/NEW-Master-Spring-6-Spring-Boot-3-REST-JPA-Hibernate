package com.example.services;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {
    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    //private Logger logger = Logger.getLogger(VehicleServices.class.getName());
    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song) {
        /*
        Instant start= Instant.now();
        logger.info("method execution start");
         */
        /*
        String music = null;
        if (vehicleStarted) {
            music = speakers.makeSound(song);
        } else {
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
         */
        /*
        logger.info("method execution end");
        Instant finish= Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
         */
        //return music;
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted) {

        /*
        Instant start= Instant.now();
        logger.info("method execution start");
         */
        /*
        String status = null;
        if(vehicleStarted)
        {
            status = tyres.rotate();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
         */
        /*
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
         */
        //return status;
        return tyres.rotate();
    }

    public String applyBreak(boolean vehicleStarted) {
        /*
        Instant start= Instant.now();
        logger.info("method execution start");
         */
        /*
        String status = null;
        if(vehicleStarted)
        {
            status = tyres.stop();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
         */
        /*
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
         */
        //return status;
        return tyres.stop();
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }
}
