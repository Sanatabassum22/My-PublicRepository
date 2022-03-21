package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Staff;
import com.sprint.model.Task;

@Repository
public interface TaskRepo  extends JpaRepository<Task, Integer>{

}