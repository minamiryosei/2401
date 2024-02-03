
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
import com.example.demo.dto.AttendanceEditUpdateRequest;
import com.example.demo.entity.AttendanceEditEntity;
import com.example.demo.service.AttendanceEditService;




public class AttendanceEditController {
	 /**
	   * ユーザー編集画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー編集画面
	   */
	  @GetMapping("/user/{id}/edit")
	  public String attendanceEdit(@PathVariable Integer id, Model model) {
		attendanceEditEntity user = attendanceEditService.findById(id);
	    attendanceEditUpdateRequest userUpdateRequest = new AttendanceEditUpdateRequest();
	    attendanceEditUpdateRequest.setId(user.getId());
	    attendanceEditUpdateRequest.setName(user.getName());
	    attendanceEditUpdateRequest.setPhone(user.getPhone());
	    attendanceEditUpdateRequest.setAddress(user.getAddress());
	    model.addAttribute("attendanceEditUpdateRequest", attendanceEditUpdateRequest);
	    return "user/edit";
	  }
	  
	  /**
	   * ユーザー更新
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @RequestMapping("/user/update")
	  public String userUpdate(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "user/edit";
	    }
	    // ユーザー情報の更新
	    userService.update(userUpdateRequest);
	    return String.format("redirect:/user/%d", userUpdateRequest.getId());
	  }
}