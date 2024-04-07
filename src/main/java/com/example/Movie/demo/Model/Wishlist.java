package com.example.Movie.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name="Wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="movieId")
    private Movie movie;

    public Wishlist() {
    }

    public Wishlist(int wishlistId, User user, Movie movie) {
        this.wishlistId = wishlistId;
        this.user = user;
        this.movie = movie;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
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

    // Getters, setters, constructors, and other methods
}