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
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.userEditDeleteUpdateRequest;
import com.example.demo.entity.userEditDelete;
import com.example.demo.service.userEditDeleteService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class userEditDeleteController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private userEditDeleteService userService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<userEditDelete> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }

  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "userRegister")
  public String displayAdd(Model model) {
    return "userRegister";
  }

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/user/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    userEditDelete user = userService.findById(id);
    model.addAttribute("userData", user);
    return "user/view";
  }

  /**
   * ユーザー編集画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー編集画面
   */
  @GetMapping("/userEditDelete/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
    userEditDelete user = userService.findById(id);
    userEditDeleteUpdateRequest userUpdateRequest = new userEditDeleteUpdateRequest();
    userUpdateRequest.setId(user.getId());
    userUpdateRequest.setName(user.getName());
    userUpdateRequest.setFurigana(user.getFurigana());
    userUpdateRequest.setMail(user.getMail());
    userUpdateRequest.setPassword(user.getPassword());
    model.addAttribute("userUpdateRequest", userUpdateRequest);
    return "user/edit";
  }

  /**
   * ユーザー更新
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @RequestMapping(value = "/user/{id}/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute userEditDeleteUpdateRequest userUpdateRequest, BindingResult result, Model model) {

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


  /**
   * ユーザー情報削除
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/user/{id}/delete")
  public String delete(@PathVariable Long id, Model model) {
    // ユーザー情報の削除
    userService.delete(id);
    return "redirect:/user/list";
  }
}