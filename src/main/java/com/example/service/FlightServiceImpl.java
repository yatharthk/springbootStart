package com.example.service;

import com.example.model.Flight;
import com.example.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("flightService")
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
    }

    @Override
    public List<Flight> getFlights(String source, String destination, LocalDate date) {
        return flightRepository.getFlights(source,destination,date);
    }
}
