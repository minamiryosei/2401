package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceEditUpdateRequest;
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
	  private AttendanceEditRepository attendanceEditSRepository;
	  /**
	   * 勤怠情報 主キー検索
	   * @return 検索結果
	   */
	  public AttendanceEditEntity findById(Integer attendance_id) {
	    return AttendanceEditRepository.findById(attendance_id).get();
	  }
	/**
	   * 勤怠編集 更新
	   * @param attendanceEdit 勤怠編集情報
	   */
	  public void update(AttendanceEditUpdateRequest attendanceEditUpdateRequest) {
		AttendanceEditEntity attendanceEdit = findById(attendanceEditUpdateRequest.getAttendance_id());
		attendanceEdit.setAttendance_id(attendanceEditUpdateRequest.getAttendance_id());
		attendanceEdit.setUser_id(attendanceEditUpdateRequest.getUser_id());
		attendanceEdit.setStatus(attendanceEditUpdateRequest.getStatus());
		attendanceEdit.setGoing_date(attendanceEditUpdateRequest.getGoing_date());
		attendanceEdit.setGoing_time(attendanceEditUpdateRequest.getGoing_time());
		attendanceEdit.setLeaving_date(attendanceEditUpdateRequest.getLeaving_date());
		attendanceEdit.setLeaving_time(attendanceEditUpdateRequest.getLeaving_time());
		attendanceEdit.setBreak_time(attendanceEditUpdateRequest.getBreak_time());
		attendanceEdit.setEdit_reason(attendanceEditUpdateRequest.getEdit_reason());
		attendanceEdit.setRemarks(attendanceEditUpdateRequest.getRemarks());
		attendanceEditRepository.save(attendanceEdit);
	  }
}
