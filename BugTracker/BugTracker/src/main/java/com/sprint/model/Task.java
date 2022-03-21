package com.sprint.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "staff_id", referencedColumnName = "staffId")
	private Staff staff;

	@OneToMany(mappedBy = "task" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Bug> bugs;
	
	@OneToMany(mappedBy = "task" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Complaint> complaints;

	public Task() {
		super();
	}

	public Task(int taskId, Staff staff) {
		super();
		this.taskId = taskId;
		this.staff = staff;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	

}