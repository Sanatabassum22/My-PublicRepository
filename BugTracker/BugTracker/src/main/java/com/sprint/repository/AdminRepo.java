package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
//	public List<Admin> findByProductName(String prodName);
//
//
//
//	@Query("SELECT prod FROM Product prod WHERE prod.price>=:pri ") // JPQL
//	public List<Admin> getByPrice(@Param("pri") double price);
}
