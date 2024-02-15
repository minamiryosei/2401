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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.userRegisterRequest;
import com.example.demo.service.userRegisterService;


/**
 * ユーザー情報 Controller
 */
@Controller
public class userRegisterController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private userRegisterService userRegisterService;

  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "userRegister")
  public String displayAdd(Model model) {
    model.addAttribute("userRegisterRequest", new userRegisterRequest());
    return "userRegister";
  }

  /**d
   * ユーザー新規登録
   * @param serRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/userRegister/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute userRegisterRequest userRequest, BindingResult result, Model model) {

    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "userRegister";
    }
    // ユーザー情報の登録
    userRegisterService.create(userRequest);
    return "redirect:/userRegister";
  }
}