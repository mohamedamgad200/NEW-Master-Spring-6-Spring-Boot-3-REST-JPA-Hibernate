package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    private Logger logger=Logger.getLogger(LoggerAspect.class.getName());
    @Around(value = "execution(* com.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().getName()+"method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute method : "+timeElapsed);
        logger.info(joinPoint.getSignature().getName()+"method execution end");
    }
    @Around("@annotation(com.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().getName()+"method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute method : "+timeElapsed);
        logger.info(joinPoint.getSignature().getName()+"method execution end");
    }

    @AfterThrowing(value = "execution(* com.example.services.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex)
    {
        logger.log(Level.SEVERE,joinPoint.getSignature() + "An exception thrown with the helper of"
                + "@AfterThrowing which happened due to : " +ex.getMessage());
    }
    @AfterReturning(value = "execution(* com.example.services.*.*(..))",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,String retVal)
    {
      logger.log(Level.SEVERE,joinPoint.getSignature().getName()
              +"Method successfully processed with the status of "+retVal.toString());
    }
}
