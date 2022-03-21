package com.sprint.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.BugNotFoundException;
import com.sprint.exception.ComplaintNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;

public interface ComplaintService {
	
	public ResponseEntity addComplaint(Complaint complaint) throws ComplaintNotFoundException;
	public ResponseEntity updateComplaint(Complaint complaint)  throws ComplaintNotFoundException;
	public ResponseEntity deleteComplaint(int complaintId)  throws ComplaintNotFoundException;
	public Complaint getComplaint(int complaintId)  throws ComplaintNotFoundException;
	public List<Complaint> getAllComplaints()  throws ComplaintNotFoundException;
	public List<Complaint> getComplaintByStaff(Staff staff)  throws ComplaintNotFoundException;
	public List<Bug> getAllBugs(Complaint complaint) throws BugNotFoundException;
}
