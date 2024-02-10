package com.example.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceEditRequest;
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
	  private AttendanceEditSRepository attendanceEditSRepository;
	/**
	   * 勤怠編集 更新
	   * @param attendanceEdit 勤怠編集情報
	   */
	  public void update(AttendanceEditRequest attendanceEditRequest) {
		AttendanceEditEntity attendance_id = findByAttendance_id(attendanceEditRequest.getAttendance_id());
	 
	    AttendanceEditEntity attendanceEdit = attendanceEditService.findByAttendance_id(Attendance_id);
	    AttendanceEditRequest attendanceEditUpdateRequest = new AttendanceEditRequest();
	    attendanceEditUpdateRequest.setAttendance_id(attendanceEdit.getAttendance_id());
	    attendanceEditUpdateRequest.setUser_id(attendanceEdit.getUser_id());
	    attendanceEditUpdateRequest.setStatus(attendanceEdit.getStatus());
	    attendanceEditUpdateRequest.setGoing_date(attendanceEdit.getGoing_date());
	    attendanceEditUpdateRequest.setGoing_time(attendanceEdit.getGoing_time());
	    attendanceEditUpdateRequest.setLeaving_date(attendanceEdit.getLeaving_date());
	    attendanceEditUpdateRequest.setLeaving_time(attendanceEdit.getLeaving_time());
	    attendanceEditUpdateRequest.setWorking_time(attendanceEdit.getWorking_time());
	    attendanceEditUpdateRequest.setBreak_time(attendanceEdit.getBreak_time());
	    attendanceEditUpdateRequest.setEdit_reason(attendanceEdit.getEdit_reason());
	    attendanceEditUpdateRequest.setRemarks(attendanceEdit.getRemarks());
	    attendanceEditRepository.save(attendanceEdit);
	  }
}
