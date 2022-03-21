package com.sprint.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.exception.BugNotFoundException;
import com.sprint.exception.ComplaintNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.repository.ComplaintRepo;

@Service("ComplaintService")
public class ComplaintServiceImpl implements ComplaintService {
	
	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public ResponseEntity addComplaint(Complaint complaint) throws ComplaintNotFoundException {
		complaintRepo.saveAndFlush(complaint);
		return new ResponseEntity("Complaint inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateComplaint(Complaint complaint) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintRepo.findById(complaint.getComplaintId()).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		complaintRepo.saveAndFlush(complaint);
		return new ResponseEntity("Complaint updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteComplaint(int complaintId) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintRepo.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		complaintRepo.deleteById(complaintId);
		return new ResponseEntity("Complaint deleted successfully",HttpStatus.OK);
	}

	@Override
	public Complaint getComplaint(int complaintId) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintRepo.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		return bean;
	}

	@Override
	public List<Complaint> getAllComplaints() throws ComplaintNotFoundException {
		return complaintRepo.findAll();
	}


	@Override
	public List<Complaint> getComplaintByStaff(Staff staff) throws ComplaintNotFoundException {
		List<Complaint> complaints = new ArrayList<Complaint>();
		try {
			for(Complaint i : complaintRepo.findAll()) {
				if(i.getStaff().equals(staff)) {
					complaints.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		return complaints;
	}

	@Override
	public List<Bug> getAllBugs(Complaint complaint) throws BugNotFoundException {
		return complaint.getBugs();
	}

}
