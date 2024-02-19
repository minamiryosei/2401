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

import com.example.demo.dto.GoingRegisterrequest;
import com.example.demo.service.GoingRegisterservice;

@Controller
public class GoingRegisterController {

	@Autowired
	private GoingRegisterservice goingRegisterService;

	@GetMapping("goingRegister")
	public String displayAdd(Model model) {
		model.addAttribute("goingRegisterrequest", new GoingRegisterrequest());
		return "GoingRegister";
	}

	@PostMapping("/goingRegister/create")
	public String create(@Validated @ModelAttribute GoingRegisterrequest goingRegisterRequest,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("ValidationError", errorList);
			return "GoingRegister";
		}

		goingRegisterService.create(goingRegisterRequest);
		return "myPage";
	}
}