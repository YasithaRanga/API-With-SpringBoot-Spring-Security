package com.javaspringrecap.javaspringrecap.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )

    private Long id;
    private String title;
    private String description;
    private String language;
    private String country;

    private Boolean subtitles = false;
    private String genre;
    private LocalDate releasedDate;
    private LocalTime duration;

    public Movie() {
    }

    public Movie(Long id, String title, String description, String language, String country, Boolean subtitles, String genre, LocalDate releasedDate, LocalTime duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.country = country;
        this.subtitles = subtitles;
        this.genre = genre;
        this.releasedDate = releasedDate;
        this.duration = duration;
    }

    public Movie(String title, String description, String language, String country, Boolean subtitles, String genre, LocalDate releasedDate, LocalTime duration) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.country = country;
        this.subtitles = subtitles;
        this.genre = genre;
        this.releasedDate = releasedDate;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(Boolean subtitles) {
        this.subtitles = subtitles;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", subtitles=" + subtitles +
                ", genre='" + genre + '\'' +
                ", releasedDate=" + releasedDate +
                ", duration=" + duration +
                '}';
    }
}
