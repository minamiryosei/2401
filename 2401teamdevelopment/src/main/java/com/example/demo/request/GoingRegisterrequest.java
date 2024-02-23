package com.example.demo.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@Max(message = "※備考欄は100文字以内で入力してください", value = 100)
	private String remarks;
}
