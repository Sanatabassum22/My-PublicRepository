package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.BugNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.repository.*;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public ResponseEntity addAdmin(Admin admin) throws AdminNotFoundException {
		adminRepo.saveAndFlush(admin);
		return  new ResponseEntity("Admin inserted successfully",HttpStatus.OK);
	}

	@Override
	public Admin getAdmin(int adminId)  throws AdminNotFoundException{
		Admin bean = null;
		try {
			bean = adminRepo.findById(adminId).get();
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public List<Admin> getAllAdmins()  throws AdminNotFoundException{
		return adminRepo.findAll();
	}	
	

}


