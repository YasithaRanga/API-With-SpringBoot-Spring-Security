package com.javaspringrecap.javaspringrecap.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowTimesWithMovieDetailsDTO {
    private Long id;
    private LocalTime time;
    private Double ticketPrice;
    private String title;
    private LocalDate releasedDate;


    public ShowTimesWithMovieDetailsDTO(Long id, LocalTime time, Double ticketPrice, String title, LocalDate releasedDate) {
        this.id = id;
        this.time = time;
        this.ticketPrice = ticketPrice;
        this.title = title;
        this.releasedDate = releasedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        return "ShowTimesWithMovieDetailsDTO{" +
                "id=" + id +
                ", time=" + time +
                ", ticketPrice=" + ticketPrice +
                ", title='" + title + '\'' +
                ", releasedDate=" + releasedDate +
                '}';
    }
}
