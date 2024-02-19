package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GoingRegisterrequest implements Serializable {

	@NotNull(message = "※ユーザーIDを入力してください")
	private Integer user_id;

	@NotBlank(message = "※ステータスの選択をしてください")
	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "※出勤日を入力してください")
	private LocalDate going_date;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "※出勤時間を入力してください")
	private LocalTime going_time;

	@Length(max = 100)
	private String remarks;
}
