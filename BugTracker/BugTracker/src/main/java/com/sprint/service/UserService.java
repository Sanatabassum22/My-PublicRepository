package com.sprint.service;

import java.util.List;

import com.sprint.model.User;

//public interface UserService {
//	
//	public String insertComplaint(User users);
//	
//	public String viewStatus(Integer complaintId);
//	
//	public String getSolution(Integer complaintId);
//
//}

import java.util.List;


import com.sprint.exception.UserNotFoundException;
import com.sprint.model.User;

public interface UserService {
	
	public User add(User user) throws UserNotFoundException;
	public User update(User user) throws UserNotFoundException;
	public User delete(User user) throws UserNotFoundException;
	public List<User> findByUsername(String username) throws UserNotFoundException;
	public User findById(int userId) throws UserNotFoundException;
    

}