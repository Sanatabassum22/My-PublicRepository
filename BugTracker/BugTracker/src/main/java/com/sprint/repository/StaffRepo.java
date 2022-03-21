package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Complaint;
import com.sprint.model.Staff;


@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer>{


}
