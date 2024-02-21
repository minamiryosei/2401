package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceEditRequest;
import com.example.demo.entity.AttendanceEditEntity;
import com.example.demo.repository.AttendanceEditRepository;


/**
 * 勤怠編集 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class AttendanceEditService {
	  /**
	   * 勤怠編集 Repository
	   */
	  @Autowired
	  private AttendanceEditRepository attendanceEditRepository;
	  /**
	   * 勤怠情報 主キー検索
	   * @return 検索結果
	   */
	  public AttendanceEditEntity findById(Integer attendance_id) {
	    return attendanceEditRepository.findById(attendance_id).get();
	  }
	/**
	   * 勤怠編集 更新
	   * @param attendanceEdit 勤怠編集情報
	   */
	  public void update(AttendanceEditRequest AttendanceEditRequest) {
		AttendanceEditEntity attendanceEdit = findById(AttendanceEditRequest.getAttendance_id());
		attendanceEdit.setAttendance_id(AttendanceEditRequest.getAttendance_id());
		attendanceEdit.setUser_id(AttendanceEditRequest.getUser_id());
		attendanceEdit.setStatus(AttendanceEditRequest.getStatus());
		attendanceEdit.setGoing_date(AttendanceEditRequest.getGoing_date());
		attendanceEdit.setGoing_time(AttendanceEditRequest.getGoing_time());
		attendanceEdit.setLeaving_date(AttendanceEditRequest.getLeaving_date());
		attendanceEdit.setLeaving_time(AttendanceEditRequest.getLeaving_time());
		attendanceEdit.setBreak_time(AttendanceEditRequest.getBreak_time());
		attendanceEdit.setEdit_reason(AttendanceEditRequest.getEdit_reason());
		attendanceEdit.setRemarks(AttendanceEditRequest.getRemarks());
		attendanceEditRepository.save(attendanceEdit);
	  }
}
