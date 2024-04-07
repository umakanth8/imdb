package com.example.Movie.demo.Model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String title;
    private Date releaseYear;
    private int duration;
    @Column(name = "average_rating")
    private double averageRating;

    @ManyToOne
    @JoinColumn(name="genreId")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="directorId")
    private Director director;

    @ManyToOne
    @JoinColumn(name="grossId")
    private Gross gross;

    @ManyToOne
    @JoinColumn(name="countryId")
    private Country country;

    public Movie() {
    }

    public Movie(int movieId, String title, Date releaseYear, int duration, double averageRating, Genre genre, Director director, Gross gross, Country country) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.averageRating = averageRating;
        this.genre = genre;
        this.director = director;
        this.gross = gross;
        this.country = country;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Gross getGross() {
        return gross;
    }

    public void setGross(Gross gross) {
        this.gross = gross;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    // Getters, setters, constructors, and other methods
}

