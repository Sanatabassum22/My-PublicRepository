package com.sprint.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

import com.sprint.exception.TaskNotFoundException;
import com.sprint.model.Bug;
import com.sprint.model.Staff;
import com.sprint.model.Task;
import com.sprint.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//http://localhost:8081/BugApp/task/addtask
	@PostMapping("/addtask")
	public ResponseEntity addTask(@RequestBody Task task) throws TaskNotFoundException{
		return taskService.addTask(task);
	}
	
	
	@PutMapping("/updatetask")
	public ResponseEntity updateTask(@RequestBody Task task)  throws TaskNotFoundException{
		return taskService.updateTask(task);
	}
	
	//http://localhost:8081/BugApp/task/gettask/{taskId}
	@GetMapping("/gettask/{taskId}")
	public Task getTask(@PathVariable int taskId)  throws TaskNotFoundException{
		return taskService.getTaskById(taskId);
	}
	
	//http://localhost:8081/BugApp/task/getalltasks
	@GetMapping("/getalltasks")
	public List<Task> getAllTasks()  throws TaskNotFoundException{
		return taskService.getAllTasks();
	}
}
