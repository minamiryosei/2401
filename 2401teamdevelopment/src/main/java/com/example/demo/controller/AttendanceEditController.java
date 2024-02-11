package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.AttendanceEditRequest;
import com.example.demo.dto.AttendanceEditUpdateRequest;
import com.example.demo.entity.AttendanceEditEntity;
import com.example.demo.service.AttendanceEditService;


/**
 * 勤怠編集 Controller
 */
@Controller
public class AttendanceEditController {

	/**
	 * 勤怠編集情報 Service
	 */
	@Autowired
	private AttendanceEditService attendanceEditService; 
/**
 * 勤怠編集画面を表示
 * @param attendance_id 表示する勤怠ID
 * @param model Model
 * @return 勤怠編集画面
 */
@GetMapping("attendanceEdit/{attendance_id}/edit")
public String displayattendanceEditEdit(@PathVariable Integer attendance_id, Model model) {
  AttendanceEditEntity attendanceEdit = attendanceEditService.findById(attendance_id);
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
  model.addAttribute("attendanceEditUpdateRequest", attendanceEditUpdateRequest);
  return "attendanceEdit";
}
/**
 * 勤怠編集
 * @param attendanceEdiRequest リクエストデータ
 * @param model Model
 * @return 勤怠編集画面
 */
@PostMapping("attendanceEdit/update")
public String attendanceEditUpdate(@Validated @ModelAttribute AttendanceEditUpdateRequest attendanceEditUpdateRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("validationError", errorList);
    return "attendanceEdit";
  }
  // 勤怠情報の更新
  attendanceEditService.update(attendanceEditUpdateRequest);
  return String.format("redirect:/attendanceEdit/%d", attendanceEditUpdateRequest.getAttendance_id());
}
}
