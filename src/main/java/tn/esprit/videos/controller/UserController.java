package tn.esprit.videos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.videos.entity.User;
import tn.esprit.videos.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUsersDetails")
    public List<User> getUsers() throws InterruptedException, ExecutionException {
        return userService.getUsersDetails();
    }
    @GetMapping("/getUserDetails/{id}")
    public User getUser(@RequestParam String id ) throws InterruptedException, ExecutionException {
        return userService.getUserDetails(id);
    }
    @PostMapping("/createUser")
    public String createUser(@RequestBody User patient ) throws InterruptedException, ExecutionException {
        return userService.saveUserDetails(patient);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User patient ) throws InterruptedException, ExecutionException {
        return userService.updateUserDetails(patient);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@RequestParam String id){
        return userService.deleteUser(id);
    }
}