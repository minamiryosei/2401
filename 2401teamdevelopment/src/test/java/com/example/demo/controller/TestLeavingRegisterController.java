package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.LeavingRegisterentity;
import com.example.demo.service.LeavingRegisterService;

@WebMvcTest(LeavingRegisterController.class)
class TestLeavingRegisterController {

	@MockBean
	LeavingRegisterService leavingRegisterService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void successfullyDisplayAdd() throws Exception {
		LeavingRegisterentity leavingRegister = new LeavingRegisterentity();
		leavingRegister.setAttendance_id(1);
		leavingRegister.setUser_id(1);
		leavingRegister.setStatus("status");
		leavingRegister.setLeaving_date(LocalDate.of(2024, 10, 10));
		leavingRegister.setLeaving_time(LocalTime.of(11, 11));
		leavingRegister.setBreak_time(LocalTime.of(0, 15));
		leavingRegister.setRemarks("remarks");
		when(leavingRegisterService.getid(1)).thenReturn(leavingRegister);
		mockMvc.perform(get("/leavingRegister/1"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("leavingRegister"))
		.andExpect(view().name("LeavingRegister"));
	}

}
