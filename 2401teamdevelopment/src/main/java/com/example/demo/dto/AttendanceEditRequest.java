
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

/**
 * ユーザー情報 Controller
 */
@Controller
public class AttendanceEditRequest {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  AttendanceEditService attendanceEditService;
  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面のHTML
   */
  //前回作成したものを使用
  }

  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping("/attendanceEdit/add")
  public String userRegister(Model model) {
    model.addAttribute("attendanceEditRequest", new AttendanceEditrRequest());
    return "attendanceEdit/add";

    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping("/user/create")
    public String userCreate(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
        // 入力チェックエラーの場合
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
      //エラー判定後の画面遷移
        model.addAttribute("validationError", errorList);
        return "user/add";
      }
      // ユーザー情報の登録
      userService.create(userRequest);
      return "redirect:/user/list";
    }

    /**
     * ユーザー情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/user/{id}")
    public String userDetail(@PathVariable Integer id, Model model) {
      UserEntity user = userService.findById(id);
      model.addAttribute("userData", user);
      return "user/view";
    }
  }