package com.example.service;

import com.example.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

   void addFlight(Flight flight);
    List<Flight> getFlights(String source, String destination, LocalDate date);
}
