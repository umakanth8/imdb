package com.example.Movie.demo.Repository;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.User;
import com.example.Movie.demo.Model.Wishlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    @Query("SELECT w FROM Wishlist w WHERE w.user = :user")
    List<Wishlist> findByUser(User user);
}
