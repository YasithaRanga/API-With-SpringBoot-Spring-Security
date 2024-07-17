package com.javaspringrecap.javaspringrecap.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table
public class ShowTime {
    @Id
    @SequenceGenerator(
            name = "showtime_sequence",
            sequenceName = "showtime_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "showtime_sequence"
    )
    private Long id;
    private Long movieId;
    private LocalTime time;
    private Double ticketPrice;

    public ShowTime() {
    }

    public ShowTime(Long id, Long movieId, LocalTime time, Double ticketPrice) {
        this.id = id;
        this.movieId = movieId;
        this.time = time;
        this.ticketPrice = ticketPrice;
    }

    public ShowTime(Long movieId, LocalTime time, Double ticketPrice) {
        this.movieId = movieId;
        this.time = time;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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

    @Override
    public String toString() {
        return "ShowTime{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", time=" + time +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
