package com.javaspringrecap.javaspringrecap.controller;

import com.javaspringrecap.javaspringrecap.model.ShowTime;
import com.javaspringrecap.javaspringrecap.service.ShowTimeService;
import com.javaspringrecap.javaspringrecap.dto.ShowTimeBookDTO;
import com.javaspringrecap.javaspringrecap.dto.ShowTimesWithMovieDetailsDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "showtimes")
public class ShowTimeController {

    private final ShowTimeService showTimeService;


    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ShowTimesWithMovieDetailsDTO> getShowTimes(@RequestParam(required = false) String filter){
        return showTimeService.getShowTimes(filter);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void addShowTime(@RequestBody ShowTime showtime) {
        showTimeService.addShowTime(showtime);
    }

    @DeleteMapping(path = "{showtimeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void removeShowTime(@PathVariable Long showtimeId) {
        showTimeService.removeShowTime(showtimeId);
    }

    @PutMapping(path = "{showtimeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateShowTime(@PathVariable Long showtimeId, @RequestParam(required = false) LocalTime time, @RequestParam(required = false) Long movieId, @RequestParam(required = false) Double ticketPrice) {
        showTimeService.updateShowTime(showtimeId, time, movieId, ticketPrice);
    }

    @PostMapping(path = "{showtimeId}/book")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ShowTimeBookDTO bookShowTime(@PathVariable Long showtimeId, @RequestParam Integer count) {
        return showTimeService.bookShowTime(showtimeId, count);
    }
}
