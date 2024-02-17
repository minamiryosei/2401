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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AttendanceEditRequest;
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
  AttendanceEditRequest AttendanceEditRequest = new AttendanceEditRequest();
  AttendanceEditRequest.setAttendance_id(attendanceEdit.getAttendance_id());
  AttendanceEditRequest.setUser_id(attendanceEdit.getUser_id());
  AttendanceEditRequest.setStatus(attendanceEdit.getStatus());
  AttendanceEditRequest.setGoing_date(attendanceEdit.getGoing_date());
  AttendanceEditRequest.setGoing_time(attendanceEdit.getGoing_time());
  AttendanceEditRequest.setLeaving_date(attendanceEdit.getLeaving_date());
  AttendanceEditRequest.setLeaving_time(attendanceEdit.getLeaving_time());
  AttendanceEditRequest.setWorking_time(attendanceEdit.getWorking_time());
  AttendanceEditRequest.setBreak_time(attendanceEdit.getBreak_time());
  AttendanceEditRequest.setEdit_reason(attendanceEdit.getEdit_reason());
  AttendanceEditRequest.setRemarks(attendanceEdit.getRemarks());
  model.addAttribute("AttendanceEditRequest", AttendanceEditRequest);
  return "attendanceEdit";
}
/**
 * 勤怠編集
 * @param attendanceEdiRequest リクエストデータ
 * @param model Model
 * @return 勤怠編集画面
 */
@RequestMapping("attendanceEdit/update")
public String attendanceEditUpdate(@Validated @ModelAttribute AttendanceEditRequest attendanceEditRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("validationError", errorList);
    return "attendanceEdit";
  }
  // 勤怠情報の更新
  attendanceEditService.update(attendanceEditRequest);
  return String.format("redirect:/attendanceEdit/%d/edit", attendanceEditRequest.getAttendance_id());
}
}
