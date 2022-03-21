package com.sprint.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprint.exception.AdminNotFoundException;
import com.sprint.exception.TaskNotFoundException;
import com.sprint.model.Admin;
import com.sprint.model.Bug;
import com.sprint.model.Staff;
import com.sprint.model.Task;

public interface TaskService {
	
	public ResponseEntity addTask(Task task) throws TaskNotFoundException;
	public ResponseEntity updateTask(Task task)  throws TaskNotFoundException;
	public Task getTaskById(int taskId)  throws TaskNotFoundException;
	public List<Task> getAllTasks()  throws TaskNotFoundException;
	public List<Task> getTasksByStaff(Staff staff) throws TaskNotFoundException;

}
