package com.sprint.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.exception.ComplaintNotFoundException;
import com.sprint.exception.StaffNotFoundException;
import com.sprint.exception.TaskNotFoundException;
import com.sprint.model.Bug;
import com.sprint.model.Complaint;
import com.sprint.model.Staff;
import com.sprint.model.Task;
import com.sprint.repository.TaskRepo;

@Service("TaskService")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public ResponseEntity addTask(Task task) throws TaskNotFoundException {
		taskRepo.saveAndFlush(task);
		return new ResponseEntity("Task inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateTask(Task task) throws TaskNotFoundException {
		Task bean = null;
		try {
			bean = taskRepo.findById(task.getTaskId()).get();
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		taskRepo.saveAndFlush(task);
		return new ResponseEntity("Task updated successfully",HttpStatus.OK);
	}

	@Override
	public Task getTaskById(int taskId) throws TaskNotFoundException {
		Task bean = null;
		try {
			bean = taskRepo.findById(taskId).get();
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		return bean;
	}

	@Override
	public List<Task> getAllTasks() throws TaskNotFoundException {
		return taskRepo.findAll();
	}

	@Override
	public List<Task> getTasksByStaff(Staff staff) throws TaskNotFoundException {
		List<Task> tasks = new ArrayList<Task>();
		try {
			for(Task i : taskRepo.findAll()) {
				if(i.getStaff().equals(staff)) {
					tasks.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		return tasks;
	}

}