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
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.expenseRegisterRequest;
import com.example.demo.entity.expenseRegisterEntity;
import com.example.demo.service.expenseRegisterService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class expenseRegisterController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private expenseRegisterService expenseRegisterService;
  
  /**
   * マイページ画面を表示
   * @param model Model
   * @return マイページ画面
   */
  @GetMapping(value = "/myPage")
  public String displayList(Model model) {
    List<expenseRegisterEntity> usermyPage = expenseRegisterService.searchAll();
    model.addAttribute("usermyPage", usermyPage);
    return "myPage";
  }
  /**
   * 経費申請画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping("expenseRegister")
  public String displayAdd(Model model) {
    model.addAttribute("expenseRegisterRequest", new expenseRegisterRequest());
    return "expenseRegister";
  }
  /**
   * 経費申請登録
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧
   */
  @PostMapping(value="/expenseRegister/create")
  public String Create(@Validated @ModelAttribute expenseRegisterRequest expenseRegisterRequest, BindingResult result, Model model) {
	  
    if (result.hasErrors()) {
    	// 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "expenseRegister";
    }
    
    // 経費申請情報の登録
    expenseRegisterService.create(expenseRegisterRequest);
    return "redirect:/myPage";
  }
  
  
  
}