package com.javaspringrecap.javaspringrecap.dto;

import java.time.LocalTime;

public class ShowTimeBookDTO {
    private String movie;
    private LocalTime showtime;
    private Integer numberOfTickets;
    private Double ticketPrice;
    private Double totalPrice;

    public ShowTimeBookDTO(String movie, LocalTime showtime, Integer numberOfTickets, Double ticketPrice, Double totalPrice) {
        this.movie = movie;
        this.showtime = showtime;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
        this.totalPrice = totalPrice;
    }

    public String getTitle() {
        return movie;
    }

    public void setTitle(String movie) {
        this.movie = movie;
    }

    public LocalTime getTime() {
        return showtime;
    }

    public void setTime(LocalTime showtime) {
        this.showtime = showtime;
    }

    public Integer getCount() {
        return numberOfTickets;
    }

    public void setCount(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Double getPrice() {
        return ticketPrice;
    }

    public void setPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getTotal() {
        return totalPrice;
    }

    public void setTotal(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShowTimeBookDTO{" +
                "movie='" + movie + '\'' +
                ", showTime=" + showtime +
                ", numberOfTickets=" + numberOfTickets +
                ", ticketPrice= $ " + ticketPrice +
                ", totalPrice= $" + totalPrice +
                '}';
    }
}
