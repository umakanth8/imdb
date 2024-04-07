package com.example.Movie.demo.Repository;

import com.example.Movie.demo.Model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT m.title FROM Movie m INNER JOIN Wishlist w ON m.movie_Id = w.movie_Id GROUP BY m.movie_Id ORDER BY COUNT(*) DESC LIMIT 5", nativeQuery = true)
    List<String> findTopWishlistedMovieTitle();


    @Query(value = "SELECT m.*, g.genre_name FROM movie m JOIN genre g ON m.genre_id = g.genre_id WHERE g.genre_name = :genreName", nativeQuery = true)
    List<Movie> findMoviesByGenreName(@Param("genreName") String genreName);


}
