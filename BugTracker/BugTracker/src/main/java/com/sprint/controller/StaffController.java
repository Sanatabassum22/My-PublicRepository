package com.sprint.controller;

import java.util.List;

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

import com.sprint.exception.BugNotFoundException;
import com.sprint.exception.ComplaintNotFoundException;
import com.sprint.exception.StaffNotFoundException;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.model.Task;
import com.sprint.repository.StaffRepo;
import com.sprint.service.ComplaintService;
import com.sprint.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/getstaff/{staffId}")
	public Staff getStaff(@PathVariable int staffId)  throws StaffNotFoundException{
		return staffService.getStaff(staffId);
	}
	
	@GetMapping("/getallstaff")
	public List<Staff> getAllStaffs()  throws StaffNotFoundException{
		return staffService.getAllStaffs();
	}
	
	@GetMapping("/getbugsbystaff")
	public List<Bug> getBugsByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getBugsByStaff(staff);
	}
	
	@GetMapping("/gettasksbystaff")
	public List<Task> getTasksByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getTasksByStaff(staff);
	}
	
	@GetMapping("/getcomplaintsbystaff")
	public List<Complaint> getComplaintsByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getComplaintsByStaff(staff);
	}

	
}












