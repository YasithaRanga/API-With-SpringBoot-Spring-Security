package com.javaspringrecap.javaspringrecap.service;

import com.javaspringrecap.javaspringrecap.model.Movie;
import com.javaspringrecap.javaspringrecap.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(String search) {
        if(search != null){
            return movieRepository.searchMovies(search);
        }
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Title is already taken");
        }
        movieRepository.save(movie);
    }

    public void removeMovie(Long id) {
        boolean exists = movieRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Movie is not found");
        }
        movieRepository.deleteById(id);
    }

    @Transactional
    public void updateMovie(Long movieId, String title, String description, String language, String country, Boolean subtitles, String genre, LocalDate releasedDate, LocalTime duration) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalStateException("Movie does not exist"));

        if(title != null && !title.isEmpty() && !Objects.equals(movie.getTitle(), title)){
            Optional<Movie> movieOptional = movieRepository.findMovieByTitle((title));
            if(movieOptional.isPresent()){
                throw new IllegalStateException("Title is already taken");
            }
            movie.setTitle(title);
        }

        if(description != null && !description.isEmpty() && !Objects.equals(movie.getDescription(), description)){
            movie.setDescription(description);
        }

        if(language != null && !language.isEmpty() && !Objects.equals(movie.getLanguage(), language)){
            movie.setLanguage(language);
        }

        if(country != null && !country.isEmpty() && !Objects.equals(movie.getCountry(), country)){
            movie.setCountry(country);
        }

        if(subtitles != null && !Objects.equals(movie.getSubtitles(), subtitles)){
            movie.setSubtitles(subtitles);
        }

        if(genre != null && !genre.isEmpty() && !Objects.equals(movie.getGenre(), genre)){
            movie.setGenre(genre);
        }

        if(releasedDate != null && !Objects.equals(movie.getReleasedDate(), releasedDate)){
            movie.setReleasedDate(releasedDate);
        }

        if(duration != null && !Objects.equals(movie.getDuration(), duration)){
            movie.setDuration(duration);
        }

    }
}
