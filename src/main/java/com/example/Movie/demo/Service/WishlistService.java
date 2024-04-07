package com.example.Movie.demo.Service;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.User;
import com.example.Movie.demo.Model.Wishlist;
import com.example.Movie.demo.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Movie> getWishlistMoviesByUser(User user) {
        List<Wishlist> wishlists = wishlistRepository.findByUser(user);
        return wishlists.stream().map(Wishlist::getMovie).collect(Collectors.toList());
    }
}

