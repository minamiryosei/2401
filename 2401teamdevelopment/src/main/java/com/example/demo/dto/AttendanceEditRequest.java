package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 勤怠編集 リクエストデータ
 */
@Data
public class AttendanceEditRequest implements Serializable {
	/**
	 * 勤怠ID
	 */
	private Long attendance_id;
	/**
	 * ユーザーID
	 */
	@NotEmpty(message = "ユーザーIDを入力してください")
	private Long user_id;
	/**
	 * ステータス
	 */
	@NotEmpty(message = "ステータスを選択してください")
	private String status;
	/**
	 * 出勤日
	 */
	@NotEmpty(message = "出勤日を入力してください")
	private LocalDate going_date;
	/**
	 * 出勤時間
	 */
	@NotEmpty(message = "出勤時間を入力してください")
	private LocalTime going_time;
	/**
	 * 退勤日
	 */
	@NotEmpty(message = "退勤日を入力してください")
	private LocalDate leaving_date;
	/**
	 * 退勤時間
	 */
	@NotEmpty(message = "退勤時間を入力してください")
	private LocalTime leaving_time;
	/**
	 * 稼働時間
	 */
	@NotEmpty(message = "稼働時間を入力してください")
	private LocalTime working_time;
	/**
	 * 休憩時間
	 */
	@NotEmpty(message = "休憩時間を入力してください")
	private LocalTime break_time;
	/**
	 * 修正理由
	 */
	@NotEmpty(message = "修正理由を入力してください")
	@Size(max = 100, message = "修正理由は100文字以内で入力してください")
	private String edit_reason;
	/**
	 * 備考
	 */
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String remarks;
}
