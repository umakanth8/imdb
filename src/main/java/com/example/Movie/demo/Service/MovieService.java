package com.example.Movie.demo.Service;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private Movie lastSuggestedMovie;
    private LocalDate lastSuggestedDate;

    public Movie suggestDailyMovie() {
        LocalDate today = LocalDate.now();

        if (today.equals(lastSuggestedDate)) {
            return lastSuggestedMovie;
        }

        List<Movie> allMovies = movieRepository.findAll();
        Movie movie = null;
        if (allMovies.size() > 1) {
            do {
                Collections.shuffle(allMovies);
                movie = allMovies.get(0);
            } while (movie.equals(lastSuggestedMovie));
        }

        lastSuggestedMovie = movie;
        lastSuggestedDate = today;
        return movie;
    }
}

