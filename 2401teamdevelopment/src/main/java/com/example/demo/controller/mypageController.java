package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mypageController {

	/**
	 * マイページ画面表示
	 * @return ユーザー情報一覧画面のHTML
	 */
	 @GetMapping("/mypage")
	  public String displayMypage() {
	    return "myPage";
	  }

}
