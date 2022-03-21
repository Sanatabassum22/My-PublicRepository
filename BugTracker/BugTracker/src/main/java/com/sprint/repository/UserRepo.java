package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Task;
import com.sprint.model.User;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{

}