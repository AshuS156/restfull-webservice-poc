package com.pathfinder.restfull.poc.controller;

import com.pathfinder.restfull.poc.beans.UserRequestBean;
import com.pathfinder.restfull.poc.beans.UserResponseBean;
import com.pathfinder.restfull.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerCurdOpration{

    @Autowired
    UserService userService;

    // Implementing HATEOAS
    @GetMapping(path = "/fetchuser/{id}" , name = "Implementing HATEOAS") // http://localhost:8080/fetchuser/1
    public EntityModel<UserResponseBean> fetchUserById(@PathVariable Long id){
        UserResponseBean user = userService.fetchUserById(id);

        EntityModel<UserResponseBean> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).fetchAllUsers());
        WebMvcLinkBuilder linkTo2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).createUser(null));
        WebMvcLinkBuilder linkTo3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).fetchUserById(id));
        WebMvcLinkBuilder linkTo4 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).deleteUserById(id));
        resource.add(linkTo.withRel("all-users"));
        resource.add(linkTo2.withRel("create-user"));
        resource.add(linkTo3.withRel("self-link"));
        resource.add(linkTo4.withRel("delete-user"));
        return resource;
    }

    @GetMapping("/fetchAllusers") // http://localhost:8080/fetchAllusers
    public ResponseEntity<List<UserResponseBean>> fetchAllUsers(){
        List<UserResponseBean> users = userService.fetchAllUsers();
        return ResponseEntity.status(200).body(users);
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
}