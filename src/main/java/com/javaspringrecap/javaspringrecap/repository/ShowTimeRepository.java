package com.javaspringrecap.javaspringrecap.repository;

import com.javaspringrecap.javaspringrecap.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
    @Query("SELECT s, m FROM ShowTime s JOIN Movie m ON s.movieId = m.id")
    List<Object> getShowTimes();

    @Query("SELECT s FROM ShowTime s WHERE s.time = ?1")
    Optional<ShowTime> findShowTimeByTime(LocalTime time);
}
