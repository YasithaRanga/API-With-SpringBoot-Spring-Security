package com.javaspringrecap.javaspringrecap.service;

import com.javaspringrecap.javaspringrecap.model.Movie;
import com.javaspringrecap.javaspringrecap.model.ShowTime;
import com.javaspringrecap.javaspringrecap.repository.MovieRepository;
import com.javaspringrecap.javaspringrecap.repository.ShowTimeRepository;
import com.javaspringrecap.javaspringrecap.dto.ShowTimeBookDTO;
import com.javaspringrecap.javaspringrecap.dto.ShowTimesWithMovieDetailsDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShowTimeService {
    private final ShowTimeRepository showTimeRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository, MovieRepository movieRepository) {
        this.showTimeRepository = showTimeRepository;
        this.movieRepository = movieRepository;
    }

    public List<ShowTimesWithMovieDetailsDTO> getShowTimes(String filter) {
        List<ShowTime> showTimes = showTimeRepository.findAll();
        List<ShowTimesWithMovieDetailsDTO> showTimeMovieDTOs = new ArrayList<>();

        for (ShowTime showTime : showTimes) {
            Optional<Movie> movieOpt = movieRepository.findById(showTime.getMovieId());
            if (movieOpt.isPresent()) {
                Movie movie = movieOpt.get();
                ShowTimesWithMovieDetailsDTO dto = new ShowTimesWithMovieDetailsDTO(
                        showTime.getId(),
                        showTime.getTime(),
                        showTime.getTicketPrice(),
                        movie.getTitle(),
                        movie.getReleasedDate()
                );
                showTimeMovieDTOs.add(dto);
            }
        }
        if(filter != null){
            if(filter.equals("movie")) {
                showTimeMovieDTOs.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
            }
            if(filter.equals("date")) {
                showTimeMovieDTOs.sort((o2, o1) -> o1.getReleasedDate().compareTo(o2.getReleasedDate()));
            }
        }
        return showTimeMovieDTOs;
    }

    public void addShowTime(ShowTime showtime) {
        Optional<ShowTime> showtimeOptional = showTimeRepository.findShowTimeByTime(showtime.getTime());
        Optional<Movie> movieOptional = movieRepository.findMovieById(showtime.getMovieId());
        if(showtimeOptional.isPresent()){
            throw new IllegalStateException("Time is already taken");
        }
        if(movieOptional.isEmpty()){
            throw new IllegalStateException("MovieId does not exist");
        }
        showTimeRepository.save(showtime);
    }

    public void removeShowTime(Long showtimeId) {
        boolean exists = showTimeRepository.existsById(showtimeId);
        if(!exists){
            throw new IllegalStateException("ShowTime does not exist");
        }
        showTimeRepository.deleteById(showtimeId);
    }

    @Transactional
    public void updateShowTime(Long showtimeId, LocalTime time, Long movieId, Double ticketPrice) {
        ShowTime showtime = showTimeRepository.findById(showtimeId).orElseThrow(() -> new IllegalStateException("ShowTime does not exist"));

        if(time != null && !Objects.equals(showtime.getTime(), time)){
            Optional<ShowTime> showtimeOptional = showTimeRepository.findShowTimeByTime(time);
            if(showtimeOptional.isPresent()){
                throw new IllegalStateException("Time is already taken");
            }
            showtime.setTime(time);
        }

        if(movieId != null && !Objects.equals(showtime.getMovieId(), movieId)){
            Optional<Movie> movieOptional = movieRepository.findMovieById(movieId);
            if(movieOptional.isEmpty()){
                throw new IllegalStateException("MovieId does not exist");
            }
            showtime.setMovieId(movieId);
        }

        if(ticketPrice != null && !Objects.equals(showtime.getTicketPrice(), ticketPrice)) {
            showtime.setTicketPrice(ticketPrice);
        }
    }

    public ShowTimeBookDTO bookShowTime(Long showtimeId, Integer count) {
        ShowTime showtime = showTimeRepository.findById(showtimeId).orElseThrow(() -> new IllegalStateException("ShowTime is not valid"));
        Movie movie = movieRepository.findById(showtime.getMovieId()).orElseThrow(() -> new IllegalStateException("Movie does not exist"));

        return new ShowTimeBookDTO(
                movie.getTitle(),
                showtime.getTime(),
                count,
                showtime.getTicketPrice(),
                showtime.getTicketPrice()*count
        );
    }
}
