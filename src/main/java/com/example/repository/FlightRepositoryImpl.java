package com.example.repository;


import com.example.model.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository{

    List<Flight> flightList = new ArrayList<>();

    @Override
    public void addFlight(Flight flight) {
        flightList.add(flight);
        System.out.println("Flight added successfully");
    }

    @Override
     public List<Flight> getFlights(String source, String destination, LocalDate journeyDate) {
        List<Flight> newFlightList = new ArrayList<>();

        flightList.forEach(x->{
            if(x.getSource().equals(source) && x.getDestination().equals(destination) &&
                    x.getJourneyDate().equals(journeyDate)){
                if(journeyDate.getMonthValue()== 12 || journeyDate.getMonthValue()==1){
                    x.setFare(x.getFare()+x.getFare()*.20);
                }
                newFlightList.add(x);
            }
        });
        return newFlightList;
    }
}
