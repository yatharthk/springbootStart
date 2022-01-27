package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.DateFormat;


@Aspect
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.service.addFight(..))")
    public void logAddTime(JoinPoint joinPoint){
        System.out.println("Starting of method "+joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}" + date);

    }

    @Around("execution(* com.example.service.getFights(..))")
    public void logGetTime(JoinPoint joinPoint){
        System.out.println("Starting of method "+joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}" + date);

    }
}
