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
@Table(name="attendance_tb")
public class goingRegisterEntity{

	@Id
	@Column(name="attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendance_id;

	@Column(name="user_id")
	private Integer user_id;

	
	@Column(name="status")
	private String status;


	@Column(name="going_date")
	private String going_date;


	@Column(name="going_time")
	private String going_time;
}