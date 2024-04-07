package com.example.Movie.demo.Service;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.User;
import com.example.Movie.demo.Repository.MovieRepository;
import com.example.Movie.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;


    public UserService() {
    }

    public User update(User user) {
        User u  = userRepository.findById(user.getUser_id()).orElse(null);
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        return userRepository.save(u);
    }
    public List<Movie> getTop10MoviesByRating() {
            return userRepository.findTop10ByAverageRating((Pageable) PageRequest.of(0, 10));
        }

//    @Transactional(readOnly = true)
//    public List<Movie> getTopMoviesWithMostWishlists() {
//        return movieRepository.findTopMoviesWithMostWishlists(PageRequest.of(0, 5));
//    }


}


