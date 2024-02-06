package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AttendanceEditEntity;

/**
 * ユーザー情報 Controller
 */
@Controller
public class AttendanceEditController {


/**
 * 
〜〜〜〜〜〜〜
上記は省略
〜〜〜〜〜〜〜
 */

/**
 * ユーザー編集画面を表示
 * @param id 表示するユーザーID
 * @param model Model
 * @return ユーザー編集画面
 */
@GetMapping("/attendanceEdit/{id}/edit")
public String attendanceEditEdit(@PathVariable Integer id, Model model) {
  AttendanceEditEntity attendanceEdit = attendanceEditService.findById(id);
  AttendanceEditRequest attendanceEditUpdateRequest = new AttendanceEditRequest();
  attendanceEditUpdateRequest.setAttendance_id(attendanceEdit.getAttendance_id());
  attendanceEditUpdateRequest.setName(attendanceEdit.getName());
  attendanceEditUpdateRequest.setPhone(attendanceEdit.getPhone());
  attendanceEditUpdateRequest.setAddress(attendanceEdit.getAddress());
  model.addAttribute("attendanceEditUpdateRequest", attendanceEditUpdateRequest);
  return "attendanceEdit/edit";
}
/**
 * ユーザー更新
 * @param userRequest リクエストデータ
 * @param model Model
 * @return ユーザー情報詳細画面
 */
@RequestMapping("/attendanceEdit/update")
public String attendanceEditUpdate(@Validated @ModelAttribute AttendanceEditRequest attendanceEditUpdateRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("validationError", errorList);
    return "attendanceEdit/edit";
  }
  // ユーザー情報の更新
  attendanceEditService.update(attendanceEditUpdateRequest);
  return String.format("redirect:/user/%d", attendanceEditUpdateRequest.getId());
}
}
