package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.AttendanceListController;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;

@WebMvcTest(AttendanceListController.class)
class AttendanceListControllerTest {

	@MockBean
	AttendanceListService attendanceListService;

	@Autowired
	private MockMvc mockMvc;


	/**
	 * 【正常系】GETリクエストが正常に処理され、attendanceList画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyAttendanceEdit() throws Exception {
		List<AttendanceListEntity> attendancelist = new ArrayList<AttendanceListEntity>();
		when(attendanceListService.searchAll()).thenReturn(attendancelist);
		mockMvc.perform(get("/attendanceList"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("attendanceList"))
				.andExpect(view().name("attendanceList"));
	}
}
