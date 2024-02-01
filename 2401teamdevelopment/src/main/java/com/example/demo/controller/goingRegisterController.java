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

import com.example.demo.request.goingRegisterrequest;
import com.example.demo.service.goingRegisterservice;

@Controller
public class goingRegisterController {

	@Autowired
	private goingRegisterservice goingRegisterService;

	@GetMapping("goingRegister")
	public String displayAdd (Model model) {
		model.addAttribute("goingRegisterRequest",new goingRegisterrequest());
		return"goingRegister";
	}

	@PostMapping("/goingRegister/create")
		public String create(@Validated @ModelAttribute goingRegisterrequest goingRegisterRequest,
			BindingResult result, Model model) {

		if(result.hasErrors()) {
			List<String> errorList=new ArrayList<String>();
			for (ObjectError error:result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());	
			}
			model.addAttribute("ValidationError",errorList);
			return "goingRegister";
		}
		
		goingRegisterService.create(goingRegisterRequest);
		return"mypage";
	}

	
}