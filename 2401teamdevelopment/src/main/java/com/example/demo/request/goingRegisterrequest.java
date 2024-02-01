package com.example.demo.request;

import java.awt.TextArea;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class goingRegisterrequest implements Serializable {

	@NotNull(message = "ユーザーIDを入力してください")
	private Integer user_id;

	@NotNull(message = "ステータスの選択をしてください")
	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message = "出勤日を入力してください")
	private String going_date;

	@DateTimeFormat(pattern = "HH:mm")
	@NotEmpty(message = "出勤時間を入力してください")
	private String going_time;

	@Length(min = 100)
	private TextArea remarks;
}
