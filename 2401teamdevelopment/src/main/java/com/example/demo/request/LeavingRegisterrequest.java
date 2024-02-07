package com.example.demo.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NonNull;

@Data
public class LeavingRegisterrequest implements Serializable {

	@NonNull(message = "ユーザーIDを入力してください")
	private Integer user_id;

	@NonNull(message = "ステータスの選択をしてください")
	private String status;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "退勤日を入力してください")
	private LocalDate Leaving_date;

	@DateTimeFormat(pattern = "HH:mm")
	@NonNull(message = "退勤時間を入力してください")
	private LocalTime Leaving_time;

	@NotNull(message = "休憩時間を選択をしてください")
	private String break_time;

	@Length(max = 100)
	private String remarks;
}
