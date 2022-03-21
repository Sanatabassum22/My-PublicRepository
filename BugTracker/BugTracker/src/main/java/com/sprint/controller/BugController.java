package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.exception.BugNotFoundException;
import com.sprint.model.Bug;
import com.sprint.model.Staff;
import com.sprint.service.BugService;

@RestController
@RequestMapping("/bug")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	@PostMapping("/addbug")
	public ResponseEntity addBug(@RequestBody Bug bug) throws BugNotFoundException{
		return bugService.addBug(bug);
	}
	
	@PutMapping("/updatebug")
	public ResponseEntity updateBug(@RequestBody Bug bug)  throws BugNotFoundException{
		return bugService.updateBug(bug);
	}
	
	@DeleteMapping("/deletebug/{bugId}")
	public ResponseEntity deleteBug(@PathVariable int bugId)  throws BugNotFoundException{
		return bugService.deleteBug(bugId);
	}
	
	@GetMapping("/getbug/{bugId}")
	public Bug getBug(@PathVariable int bugId)  throws BugNotFoundException{
		return bugService.getBug(bugId);
	}
	
	@GetMapping("/getallbug")
	public List<Bug> getAllBugs()  throws BugNotFoundException{
		return bugService.getAllBugs();
	}
	
	@GetMapping("/getbugsbystatus/{status}")
	public List<Bug> getBugsByStatus(@PathVariable String status) throws BugNotFoundException{
		return bugService.getBugsByStatus(status);
	}
	
	@GetMapping("/transferbug")
	public ResponseEntity transferBug(@RequestBody Bug bug,@RequestBody Staff staff) throws BugNotFoundException{
		return bugService.transferBug(bug, staff);
	}

}
