package com.pathfinder.restfull.poc.service;

import com.pathfinder.restfull.poc.beans.UserRequestBean;
import com.pathfinder.restfull.poc.beans.UserResponseBean;
import com.pathfinder.restfull.poc.exception.UserNotFoundException;
import com.pathfinder.restfull.poc.model.UserEntity;
import com.pathfinder.restfull.poc.repository.UserRepository;
import com.pathfinder.restfull.poc.utility.CommonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService{

    @Autowired
    UserRepository userRepository;

    // get All users - @GetMapping
    public List<UserResponseBean> fetchAllUsers(){
        final List<UserEntity> userEntityList = userRepository.findAll();
        //log.info("userEntityList : {}",userEntityList);
        return userEntityList.stream().map(UserResponseBean::new).toList();

    }

    // fetch user based on id/name//status and all - @GetMapping

    public UserResponseBean fetchUserById(Long id){
        final UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found for the given id : " + id));
       // log.info("userEntity : {}",userEntity);
        return new UserResponseBean(userEntity);
    }

    //save user - @PostMapping
    public UserResponseBean createUser(UserRequestBean userRequestBean){
        final UserEntity userEntity = CommonUtility.constructAndSaveUserEntity(userRequestBean);
        final UserEntity savedUserEntity = userRepository.save(userEntity);
        //log.info("savedUserEntity : {}",savedUserEntity);
        return new UserResponseBean(savedUserEntity);
    }



    // delete user - @DeleteMapping
    public void deleteUserById(Long id){
        final Optional<UserEntity> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new UserNotFoundException("User not found for the given id : " + id);
        }
    }

    // update user - @putMapping
    public UserResponseBean updateUser(Long id,UserRequestBean userRequestBean){
        final Optional<UserEntity> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            UserEntity existingUser = userById.get();
            existingUser.setName(userRequestBean.getName());
            existingUser.setEmail(userRequestBean.getEmail());
            existingUser.setStatus(userRequestBean.getStatus());
            final UserEntity updatedUser = userRepository.save(existingUser);
            return new UserResponseBean(updatedUser);
        }
        else {
            throw new UserNotFoundException("User not found for the given id : " + id);
        }
    }

    // partial update user - @PatchMapping
    public UserResponseBean partialUpdateUser(Long id,UserRequestBean userRequestBean){
        final Optional<UserEntity> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            UserEntity existingUser = userById.get();
            if (userRequestBean.getName() != null) {
                existingUser.setName(userRequestBean.getName());
            }
            if (userRequestBean.getEmail() != null) {
                existingUser.setEmail(userRequestBean.getEmail());
            }
            if (userRequestBean.getStatus() != null) {
                existingUser.setStatus(userRequestBean.getStatus());
            }
            final UserEntity updatedUser = userRepository.save(existingUser);
            return new UserResponseBean(updatedUser);
        }
        else {
            throw new UserNotFoundException("User not found for the given id : " + id);
        }
    }


}
