package com.sprint.service;

import java.util.List;

import com.sprint.model.User;

//public interface AdminService {
//
//	public String getComplaint(User users);
//
//	public int assignComplaint(User users_id);
//
//	public String viewStatus(Integer complaintId);
//
//}


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.BugNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;


public interface AdminService {
	
	public ResponseEntity addAdmin(Admin admin) throws AdminNotFoundException;
	public Admin getAdmin(int adminId)  throws AdminNotFoundException;
	public List<Admin> getAllAdmins()  throws AdminNotFoundException;
	
}