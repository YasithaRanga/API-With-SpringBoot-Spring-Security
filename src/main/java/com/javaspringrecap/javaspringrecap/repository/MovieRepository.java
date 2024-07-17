package com.javaspringrecap.javaspringrecap.repository;

import com.javaspringrecap.javaspringrecap.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.title = ?1")
    Optional<Movie> findMovieByTitle(String title);

    @Query("SELECT m FROM Movie m WHERE m.id = ?1")
    Optional<Movie> findMovieById(Long id);

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %?1%")
    List<Movie> searchMovies(String search);
}
