package com.sprint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.BugNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Staff;
import com.sprint.repository.BugRepo;

@Service("BugService")
public class BugServiceImpl implements BugService {
	
	@Autowired
	private BugRepo bugRepo;

	@Override
	public ResponseEntity addBug(Bug bug) throws BugNotFoundException {
		bugRepo.saveAndFlush(bug);
		return new ResponseEntity("Bug inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateBug(Bug bug) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugRepo.findById(bug.getBugId()).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bugRepo.saveAndFlush(bug);
		return new ResponseEntity("Bug updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteBug(int bugId) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugRepo.findById(bugId).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bugRepo.deleteById(bugId);
		return new ResponseEntity("Bug deleted successfully",HttpStatus.OK);
	}

	@Override
	public Bug getBug(int bugId) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugRepo.findById(bugId).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		return bean;
	}

	@Override
	public List<Bug> getAllBugs() throws BugNotFoundException {
		return bugRepo.findAll();
	}

	@Override
	public List<Bug> getBugsByStatus(String status) throws BugNotFoundException {
		List<Bug> bugs = new ArrayList<Bug>();
		try {
			for(Bug i : bugRepo.findAll()) {
				if(i.getBugStatus().equals(status)) {
					bugs.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		return bugs;
	}

	@Override
	public ResponseEntity transferBug(Bug bug, Staff staff) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugRepo.findById(bug.getBugId()).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bug.setStaff(staff);
		return new ResponseEntity("Bug transfered successfully",HttpStatus.OK);
	}

}
