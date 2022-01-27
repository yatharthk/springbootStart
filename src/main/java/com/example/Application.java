package com.example;


import com.example.model.Flight;
import com.example.service.FlightService;
import com.example.service.FlightServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.example")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Scanner sc = new Scanner(System.in);
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        FlightService flightService = context.getBean("flightService", FlightServiceImpl.class);


        String airlineName = "", source = "", destination = "", journeyDate = "";
        int seatCount = 0;
        double fare = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the operation you want to perform/ 1. Add Flight \n 2. Search Flight \n");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Flight flight = new Flight();
                    System.out.println("Enter flight details:");
                    System.out.println("Enter airlines");
                    airlineName = sc.next();
                    System.out.println("Enter source");
                    source = sc.next();
                    System.out.println("Enter destination");
                    destination = sc.next();
                    System.out.println("Enter fare");
                    fare = sc.nextDouble();
                    System.out.println("Enter journeyDate yyyy-MM-dd");
                    journeyDate = sc.next();
                    System.out.println("Enter seat count");
                    seatCount = sc.nextInt();

                    flight.setAirlines(airlineName);
                    flight.setSource(source);
                    flight.setDestination(destination);
                    flight.setJourneyDate(LocalDate.parse(journeyDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    flight.setSeatCount(seatCount);
                    flight.setFare(fare);
                    System.out.println("Adding flight now with id"+ flight.getFlightId());
                    flightService.addFlight(flight);
                    System.out.println("Added");

                    break;
                case 2:
                    System.out.println("Enter the source,destination and you journey date");
                    System.out.println("Enter source");
                    source = sc.next();
                    System.out.println("Enter destination");
                    destination = sc.next();
                    System.out.println("Enter journeyDate yyyy-MM-dd");
                    journeyDate = sc.next();

                    LocalDate journeyDateObj= LocalDate.parse(journeyDate, DateTimeFormatter.ofPattern("yyy-MM-dd"));
                    List<Flight> flightList = flightService.getFlights(source,destination,journeyDateObj);
                    if (flightList.isEmpty()) {
                        System.out.println("Sorry no flights found");
                    } else {
                        System.out.println("Flights found !!!");
                        flightList.forEach(System.out::println);
                    }
                    break;
                default:
                    System.out.println("Sorry invalid choice valid ones are 1 and 2");
                    break;
            }
            System.out.println("Do you want to continue? y/n");
            flag = sc.next().equals('n') ? false : true;

        }

    }
}
