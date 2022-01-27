package com.example.model;

import java.time.LocalDate;

public class Flight {
    static int COUNTER=100;

    private String flightId;
    private String airlines;
    private String source;
    private String destination;
    private Double fare;
    private LocalDate journeyDate;
    private Integer seatCount;

    //Getter & Setter Methods

    static int getLatestFlight() {
        return COUNTER+=1;
    }

    public Flight() {
        this.flightId=getLatestFlight()+"";
    }

    public Flight(String airlines, String source, String destination, Double fare, LocalDate journeyDate, Integer seatCount) {
        this.flightId = getLatestFlight()+"";
        this.airlines = airlines;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.journeyDate = journeyDate;
        this.seatCount = seatCount;
    }

    public String getFlightId() {
        return flightId;
    }


    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", airlines='" + airlines + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", journeyDate=" + journeyDate +
                ", seatCount=" + seatCount +
                '}';
    }
}