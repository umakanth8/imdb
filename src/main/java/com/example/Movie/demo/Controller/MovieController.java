package com.example.Movie.demo.Controller;


import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.Wishlist;
import com.example.Movie.demo.Repository.MovieRepository;
import com.example.Movie.demo.Repository.WishlistRepository;
import com.example.Movie.demo.Service.MovieService;
import com.example.Movie.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private UserService movieService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private WishlistRepository wishlistRepository;

    @GetMapping("/top-rated")
    public ResponseEntity<List<String>> getTopRatedMovies() {
        List<String> list = new ArrayList<>();
        List<Movie> movies = movieService.getTop10MoviesByRating();
        for (Movie m : movies) {
            list.add(m.getTitle());
        }
        return ResponseEntity.ok(list);
    }
    public MovieController(UserService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top_wishlist")
    public List<Wishlist> getmvie(){
        return wishlistRepository.findAll();
    }

    @GetMapping("/top_w")
    public List<String> getmovie(){
        return movieRepository.findTopWishlistedMovieTitle();
    }

    @Autowired
    private MovieService movService;

    @GetMapping("/suggest-daily")
    public ResponseEntity<Movie> getSuggestedDailyMovie() {
        Movie movie = movService.suggestDailyMovie();
        return ResponseEntity.ok(movie);
    }
    @GetMapping("/details/{name}")
    public Movie getmoviebyName(@PathVariable String name){
        List<Movie> m = movieRepository.findAll();
        for (Movie mo : m){
            if(mo.getTitle().equals(name)){
                return mo;
            }

        }
        return null;
    }
    @GetMapping("/getAllMovies")
    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }


    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genreName) {
        List<Movie> movies = movieRepository.findMoviesByGenreName(genreName);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @GetMapping("/search/{movie}")
    public List<Movie> search(@PathVariable String movie){
        List<Movie> m= movieRepository.findAll();
        List<Movie> list = new ArrayList<>();
        for (Movie mo: m) {
            if (mo.getTitle().contains(movie)) {
                list.add(mo);
            }
        }
        return list;
    }




}

