package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "attendance_tb")
public class GoingRegisterEntity {

	@Id
	@Column(name = "attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendance_id;

	@Column(name = "user_id")
	private Integer user_id;

	@Column(name = "status")
	private String status;

	@Column(name = "going_date")
	private LocalDate going_date;

	@Column(name = "going_time")
	private LocalTime going_time;

	@Column(name = "remarks")
	private String remarks;
}
