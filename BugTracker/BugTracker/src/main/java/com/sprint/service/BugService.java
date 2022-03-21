package com.sprint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.BugNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Staff;

public interface BugService {
	
	public ResponseEntity addBug(Bug bug) throws BugNotFoundException;
	public ResponseEntity updateBug(Bug bug)  throws BugNotFoundException;
	public ResponseEntity deleteBug(int bugId)  throws BugNotFoundException;
	public Bug getBug(int bugId)  throws BugNotFoundException;
	public List<Bug> getAllBugs()  throws BugNotFoundException;
	public List<Bug> getBugsByStatus(String status) throws BugNotFoundException; 
	public ResponseEntity transferBug(Bug bug,Staff staff) throws BugNotFoundException; 
}
