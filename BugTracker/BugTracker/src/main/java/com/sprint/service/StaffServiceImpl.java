package com.sprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.exception.BugNotFoundException;
import com.sprint.exception.StaffNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.model.Task;
import com.sprint.repository.StaffRepo;

@Service("StaffService")
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffRepo staffRepo;

	@Override
	public ResponseEntity addStaff(Staff staff) throws StaffNotFoundException {
		staffRepo.saveAndFlush(staff);
		return new ResponseEntity("Staff inserted successfully",HttpStatus.OK);
	}

	@Override
	public Staff getStaff(int staffId) throws StaffNotFoundException {
		Staff bean = null;
		try {
			bean = staffRepo.findById(staffId).get();
		}
		catch(Exception e) {
			throw new StaffNotFoundException("Staff details not found!");
		}
		return bean;
	}

	@Override
	public List<Staff> getAllStaffs() throws StaffNotFoundException {
		return staffRepo.findAll();
	}

	@Override
	public List<Bug> getBugsByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getBugs();
	}

	@Override
	public List<Task> getTasksByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getTasks();
	}

	@Override
	public List<Complaint> getComplaintsByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getComplaints();
	}

}
