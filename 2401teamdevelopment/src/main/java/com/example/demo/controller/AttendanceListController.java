package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;
/**
 * 勤怠一覧 Controller
 */
@Controller
public class AttendanceListController {

  /**
   * 勤怠一覧情報 Service
   */
  @Autowired
  private AttendanceListService attendanceListService;

  /**
   * 勤怠一覧画面を表示
   * @param model Model
   * @return 勤怠一覧画面のHTML
   */
  @RequestMapping("attendanceList")
  public String attendanceList(Model model) {
    List<AttendanceListEntity> attendancelist = attendanceListService.searchAll();
    model.addAttribute("attendanceList", attendancelist);
    return "attendanceList";
  }

 
}