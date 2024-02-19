package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserListEntity;
import com.example.demo.service.UserListService;






/**
 * ユーザー情報 Controller
 */
@Controller
public class UserListController {


  /**
   * ユーザー情報 Service
   */
  @Autowired
  UserListService userlistService;


  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面のHTML
   */
  @GetMapping(value="/user/userList")
  public String userList(Model model) {
    List<UserListEntity> userList = userlistService.searchAll();
    model.addAttribute("userList", userList);
    return "user/userList";
  }
}