package com.sprint.service;

//public interface StaffService {
//
//	public String viewComplaint(Integer complaintId);
//	
//	public String giveSolution(Integer complaintId);
//
//	public void forwardToOthers(Integer staff_id,Integer complaintId); // complaint id
//
//}

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.StaffNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.model.Task;

public interface StaffService {
	
	public ResponseEntity addStaff(Staff staff) throws StaffNotFoundException;
	public Staff getStaff(int staffId)  throws StaffNotFoundException;
	public List<Staff> getAllStaffs()  throws StaffNotFoundException;
	public List<Bug> getBugsByStaff(Staff staff)  throws StaffNotFoundException;
	public List<Task> getTasksByStaff(Staff staff)  throws StaffNotFoundException;
	public List<Complaint> getComplaintsByStaff(Staff staff)  throws StaffNotFoundException;

}