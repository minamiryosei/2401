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

import com.example.demo.dto.AttendanceEditRequest;
import com.example.demo.entity.AttendanceEditEntity;
import com.example.demo.service.AttendanceEditService;

@WebMvcTest(AttendanceEditController.class)
class TestAttendanceEdit {

	@MockBean
	AttendanceEditService attendanceEditService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 【正常系】GETリクエストが正常に処理され、attendanceEdit画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyDisplayAdd() throws Exception {
		AttendanceEditEntity attendanceEdit = new AttendanceEditEntity();
		attendanceEdit.setAttendance_id(1);
		attendanceEdit.setUser_id(1);
		attendanceEdit.setStatus("status");
		attendanceEdit.setGoing_date(LocalDate.of(2024, 10, 10));
		attendanceEdit.setGoing_time(LocalTime.of(11, 30));
		attendanceEdit.setLeaving_date(LocalDate.of(2024, 10, 10));
		attendanceEdit.setLeaving_time(LocalTime.of(15, 30));
		attendanceEdit.setWorking_time(LocalTime.of(8, 00));
		attendanceEdit.setBreak_time(LocalTime.of(1, 0));
		attendanceEdit.setEdit_reason("reason");
		attendanceEdit.setRemarks("remarks");
		when(attendanceEditService.findById(1)).thenReturn(attendanceEdit);
		mockMvc.perform(get("/attendanceEdit/1/"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("AttendanceEditRequest"))
				.andExpect(view().name("attendanceEdit"));
	}

	/**
	 * 【正常系】POSTリクエストが正常に処理され、redirect:/attendanceListがreturnされることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyUpdate() throws Exception{
		AttendanceEditRequest attendanceEditRequest = new AttendanceEditRequest();
		attendanceEditRequest.setAttendance_id(1);
		attendanceEditRequest.setUser_id(1);
		attendanceEditRequest.setStatus("status");
		attendanceEditRequest.setGoing_date(LocalDate.of(2024, 10, 10));
		attendanceEditRequest.setGoing_time(LocalTime.of(11, 30));
		attendanceEditRequest.setLeaving_date(LocalDate.of(2024, 10, 10));
		attendanceEditRequest.setLeaving_time(LocalTime.of(15, 30));
		attendanceEditRequest.setWorking_time(LocalTime.of(8, 00));
		attendanceEditRequest.setBreak_time(LocalTime.of(1, 0));
		attendanceEditRequest.setEdit_reason("reason");
		attendanceEditRequest.setRemarks("remarks");
		mockMvc.perform((post("/attendanceEdit/update")).flashAttr("attendanceEditRequest", attendanceEditRequest))
		.andExpect(model().hasNoErrors())
		.andExpect(view().name("redirect:/attendanceList"));
	}

	}