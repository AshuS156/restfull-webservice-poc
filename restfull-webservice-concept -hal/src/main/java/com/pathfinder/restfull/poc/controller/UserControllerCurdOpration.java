package com.pathfinder.restfull.poc.controller;

import com.pathfinder.restfull.poc.beans.UserRequestBean;
import com.pathfinder.restfull.poc.beans.UserResponseBean;
import com.pathfinder.restfull.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerCurdOpration{

    @Autowired
    UserService userService;

    @GetMapping("/fetchAllusers") // http://localhost:8080/fetchAllusers
    public ResponseEntity<List<UserResponseBean>> fetchAllUsers(){
        List<UserResponseBean> users = userService.fetchAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/fetchuser/{id}") // http://localhost:8080/fetchuser/1
    public ResponseEntity<UserResponseBean> fetchUserById(@PathVariable  Long id){
        UserResponseBean user = userService.fetchUserById(id);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/createuser") // http://localhost:8080/createuser
    public ResponseEntity<UserResponseBean> createUser(@RequestBody UserRequestBean requestBean){
        UserResponseBean createdUser = userService.createUser(requestBean);
        return ResponseEntity.status(201).body(createdUser);
    }

    @DeleteMapping("/deleteuser/{id}") // http://localhost:8080/deleteuser/1
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateuser/{id}") // http://localhost:8080/updateuser/1
    public ResponseEntity<UserResponseBean> updateUser(@PathVariable Long id, @RequestBody UserRequestBean requestBean){
        UserResponseBean updatedUser = userService.updateUser(id, requestBean);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/patchuser/{id}") // http://localhost:8080/patchuser/1
    public ResponseEntity<UserResponseBean> patchUser(@PathVariable Long id, @RequestBody UserRequestBean requestBean){
        UserResponseBean patchedUser = userService.partialUpdateUser(id, requestBean);
        return ResponseEntity.ok(patchedUser);
    }
}
