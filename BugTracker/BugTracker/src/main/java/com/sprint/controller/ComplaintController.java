package com.sprint.controller;

import java.time.LocalDate;
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
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.service.ComplaintService;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {
	
	@Autowired
	private ComplaintService complaintService;
	
	//http://localhost:8081/BugApp/complaint/addcomplaint
	@PostMapping("/addcomplaint")
	public ResponseEntity addComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException{
		return complaintService.addComplaint(complaint);
	}
	
	@PutMapping("/updatecomplaint")
	public ResponseEntity updateComplaint(@RequestBody Complaint complaint)  throws ComplaintNotFoundException{
		return complaintService.updateComplaint(complaint);
	}
	
	@DeleteMapping("/deletecomplaint/{complaintId}")
	public ResponseEntity deleteComplaint(@PathVariable int complaintId)  throws ComplaintNotFoundException{
		return complaintService.deleteComplaint(complaintId);
	}
	
	//http://localhost:8081/BugApp/complaint/getcomplaint/1
	@GetMapping("/getcomplaint/{complaintId}")
	public Complaint getComplaint(@PathVariable int complaintId)  throws ComplaintNotFoundException{
		return complaintService.getComplaint(complaintId);
	}
	
	//http://localhost:8081/BugApp/complaint/getallcomplaint
	@GetMapping("/getallcomplaint")
	public List<Complaint> getAllComplaints()  throws ComplaintNotFoundException{
		return complaintService.getAllComplaints();
	}
	
	//http://localhost:8081/BugApp/complaint/getcomplaintbystaff
	@GetMapping("/getcomplaintbystaff")
	public List<Complaint> getComplaintByStaff(@RequestBody Staff staff)  throws ComplaintNotFoundException{
		return complaintService.getComplaintByStaff(staff);
	}
	
	//http://localhost:8081/BugApp/complaint/getbugsbycomplaint
	@GetMapping("/getbugsbycomplaint")
	public List<Bug> getAllBugs(@RequestBody Complaint complaint) throws BugNotFoundException{
		return complaintService.getAllBugs(complaint);
	}

}
