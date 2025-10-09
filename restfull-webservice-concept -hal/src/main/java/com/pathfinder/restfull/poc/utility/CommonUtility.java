package com.pathfinder.restfull.poc.utility;

import com.pathfinder.restfull.poc.beans.UserRequestBean;
import com.pathfinder.restfull.poc.model.UserEntity;

import java.util.Optional;

public class CommonUtility{

    public static  UserEntity constructAndSaveUserEntity(UserRequestBean userRequestBean){
        UserEntity userEntity = Optional.ofNullable(userRequestBean)
                .map(request -> {
                    UserEntity entity = new UserEntity();
                    entity.setName(request.getName());
                    entity.setEmail(request.getEmail());
                    entity.setCity(request.getCity());
                    entity.setStatus(request.getStatus());
                    entity.setPhones(request.getPhones());
                    entity.setDob(request.getDob());
                    return entity;
                }) .orElseThrow(() -> new IllegalArgumentException("UserRequestBean cannot be null"));
        return userEntity;
    }
}
