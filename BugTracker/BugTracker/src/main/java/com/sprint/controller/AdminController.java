package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.model.Admin;
import com.sprint.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	//http://localhost:8081/BugApp/admin/addadmin
	@PostMapping("/addadmin")
	public ResponseEntity addAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/getadmin/{adminId}")
	public Admin getAdmin(@PathVariable int adminId)  throws AdminNotFoundException{
		return adminService.getAdmin(adminId);
	}
	
	@GetMapping("/getalladmin")
	public List<Admin> getAllAdmins()  throws AdminNotFoundException{
		return adminService.getAllAdmins();
	}
	
	

}