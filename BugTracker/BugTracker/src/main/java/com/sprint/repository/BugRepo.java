package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Bug;

@Repository
public interface BugRepo extends JpaRepository<Bug, Integer>{


}
