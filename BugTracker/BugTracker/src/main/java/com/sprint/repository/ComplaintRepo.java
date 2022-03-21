package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Bug;
import com.sprint.model.Complaint;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer>{

}
