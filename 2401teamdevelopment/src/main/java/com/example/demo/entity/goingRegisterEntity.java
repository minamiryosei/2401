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


	@Column(name="going_date")
	private String going_date;


	@Column(name="going_time")
	private String going_time;
}