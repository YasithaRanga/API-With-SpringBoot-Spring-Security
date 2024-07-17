package com.javaspringrecap.javaspringrecap.controller;

import com.javaspringrecap.javaspringrecap.model.Movie;
import com.javaspringrecap.javaspringrecap.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Movie> getMovies(@RequestParam(required = false) String search) {
        return movieService.getMovies(search);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @DeleteMapping(path = "{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void removeMovie(@PathVariable("movieId") Long movieId) {
        movieService.removeMovie(movieId);
    }

    @PutMapping(path = "{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateMovie(@PathVariable("movieId") Long movieId,
                            @RequestParam(required = false) String title,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String language,
                            @RequestParam(required = false) String country,
                            @RequestParam(required = false) Boolean subtitles,
                            @RequestParam(required = false) String genre,
                            @RequestParam(required = false) LocalDate releasedDate,
                            @RequestParam(required = false) LocalTime duration
                            ) {
        movieService.updateMovie(movieId, title, description, language, country, subtitles, genre, releasedDate, duration);
    }
}
