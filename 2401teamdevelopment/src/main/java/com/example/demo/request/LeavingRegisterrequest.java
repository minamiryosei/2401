package com.example.demo.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LeavingRegisterrequest implements Serializable {

	@NotNull(message = "※ユーザーIDを入力してください")
	private Integer user_id;

	@NotNull(message = "※ステータスの選択をしてください")
	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "※退勤日を入力してください")
	private LocalDate leaving_date;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "※退勤時間を入力してください")
	private LocalTime leaving_time;

	@NotBlank(message = "※休憩時間を選択をしてください")
	private String break_time;

	@Length(max = 100)
	private String remarks;
}
