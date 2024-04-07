package com.example.Movie.demo.Controller;

import com.example.Movie.demo.Model.Movie;
import com.example.Movie.demo.Model.User;
import com.example.Movie.demo.Repository.UserRepository;
import com.example.Movie.demo.Repository.WishlistRepository;
import com.example.Movie.demo.Service.UserService;
import com.example.Movie.demo.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String create(@RequestBody User user){
            userRepository.save(user);
            return "user saved successfully";
    }
    @GetMapping("/get")
    public List<User> get(){
        return userRepository.findAll();
    }
//List<Integer> list = new ArrayList<>();


    @GetMapping("/login/{name}/{pass}")
    public String login(@PathVariable String name, @PathVariable String pass){
        List<User> user= userRepository.findAll();
        for (User u: user){
            if(u.getUsername().equals(name) && u.getPassword().equals(pass)){
                return "login successful";
            }
        }
        return "login failed";
    }
    @PostMapping("/register")
    public void register(@RequestBody User user){
        userRepository.save(user);
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody  User user)
    {
        userService.update(user);
        return new ResponseEntity<>("user updated", HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public Optional<User> getuser(@PathVariable Long id){
          Optional<User> user =  userRepository.findById(id);
          return user;
        }


    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private WishlistRepository wishlistRepository;


    @GetMapping("/wishlisted/{username}")
    public List<Movie> getWishlistForUser(@PathVariable String username) {
       // User user = userService.findByUsername(username);
        List<User> list = userRepository.findAll();
        for(User user: list){
            if(user.getUsername().equals(username)){
                return wishlistService.getWishlistMoviesByUser(user);
            }
        }
       return null;
    }








}
