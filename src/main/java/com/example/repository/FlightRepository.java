package com.example.repository;

import com.example.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository {
    void addFlight(Flight flight);
    List<Flight> getFlights(String source, String destination, LocalDate date);
}

