package com.example.Movie.demo.Repository;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT m FROM Movie m JOIN UserRating ur ON m.movieId = ur.movie.movieId GROUP BY m.movieId ORDER BY AVG(ur.rating) DESC")
    List<Movie> findTop10ByAverageRating(Pageable pageable);



}
