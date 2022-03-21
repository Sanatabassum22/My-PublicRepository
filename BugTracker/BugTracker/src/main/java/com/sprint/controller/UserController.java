package com.sprint.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.exception.TaskNotFoundException;
import com.sprint.exception.UserNotFoundException;
import com.sprint.model.Bug;
import com.sprint.model.Staff;
import com.sprint.model.Task;
import com.sprint.model.User;
import com.sprint.service.TaskService;
import com.sprint.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8081/BugApp/user/adduser
	@PostMapping("/adduser")
	public User add(User user) throws UserNotFoundException{
		return userService.add(user);
	}
	
	@PutMapping("/updateuser")
	public User update(User user) throws UserNotFoundException{
		return userService.update(user);
	}
	
	//http://localhost:8081/BugApp/user/deleteuser
	@DeleteMapping("/deleteuser")
	public User delete(User user) throws UserNotFoundException{
		return userService.delete(user);
	}
	
	
	//http://localhost:8081/BugApp/user/getuserbyusername/
	@GetMapping("/getuserbyusername/{username}")
	public List<User> findByUsername(String username) throws UserNotFoundException{
		return userService.findByUsername(username);
	}
	
	//http://localhost:8081/BugApp/user//getuserbyid/1
	@GetMapping("/getuserbyid/{userId}")
	public User findById(int userId) throws UserNotFoundException{
		return userService.findById(userId);
	}

}