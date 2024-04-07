package com.example.Movie.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name="User_rating")
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRatingId;
    private double rating;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="movieId")
    private Movie movie;

    // Getters, setters, constructors, and other methods

    public UserRating(int userRatingId, double rating, User user, Movie movie) {
        this.userRatingId = userRatingId;
        this.rating = rating;
        this.user = user;
        this.movie = movie;
    }

    public UserRating() {
    }

    public int getUserRatingId() {
        return userRatingId;
    }

    public void setUserRatingId(int userRatingId) {
        this.userRatingId = userRatingId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
