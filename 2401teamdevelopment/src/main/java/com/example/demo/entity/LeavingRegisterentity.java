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
@Table

public class LeavingRegisterentity {

	@Id
	@Column(name = "attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendance_id;

	@Column(name = "user_id")
	private Integer user_id;

	@Column(name = "status")
	private String status;

	@Column(name = "leaving_date")
	private LocalDate leaving_date;

	@Column(name = "leaving_time")
	private LocalTime leaving_time;

	@Column(name = "break_time")
	private String break_time;

	@Column(name = "remarks")
	private String remarks;

}
