
package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 勤怠一覧 Entity
 */
@Entity
@Data
@Table(name = "attendance_tb",schema = "public")
public class  AttendanceEditEntity implements Serializable {
  /**
   * 勤怠ID
   */
  @Id
  @Column(name = "attendance_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer  attendance_id;
  /**
   * ユーザーID
   */
  @Column(name = "user_id")
  private Integer  user_id;
  /**
   * ステータス
   */
  @Column(name = "status")
  private String status;
  /**
   * 出勤日
   */
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  @Column(name = "going_date")
  private LocalDate going_date;
  /**
   * 出勤時間
   */
  @DateTimeFormat(pattern = "HH:mm")
  @Column(name = "going_time")
  private LocalTime going_time;
  /**
   * 退勤日
   */
  @Column(name = "leaving_date")
  private LocalDate leaving_date;
  /**
   * 退勤時間
   */
  @DateTimeFormat(pattern = "HH:mm")
  @Column(name = "leaving_time")
  private LocalTime leaving_time;
  /**
   * 稼働時間
   */
  @DateTimeFormat(pattern = "HH:mm")
  @Column(name = "working_time")
  private LocalTime working_time;
  /**
   * 休憩時間
   */
  @DateTimeFormat(pattern = "HH:mm")
  @Column(name = "break_time")
  private LocalTime break_time;
  /**
   * 修正理由
   */
  @Column(name = "edit_reason")
  private String edit_reason;
  /**
   * 修正理由
   */
  @Column(name = "remarks")
  private String remarks;
}