package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="goingRegister_table")
public class goingRegisterEntity{

	@Id
	@Column(name="Attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="goingday")
	private String goingday;
	
	
	@Column(name="goingtime")
	private String goingtime;
}
	
	








