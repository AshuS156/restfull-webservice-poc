package com.pathfinder.restfull.poc.repository;

import com.pathfinder.restfull.poc.beans.UserRequestBean;
import com.pathfinder.restfull.poc.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
