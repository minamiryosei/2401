package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.AttendanceListController;
import com.example.demo.service.AttendanceListService;

/**
* テストクラス kanggo AttendanceListController.
*/
@WebMvcTest(AttendanceListController.class)
public class AttendanceListControllerTest {

@MockBean
AttendanceListService attendanceListService;

@Autowired
private AttendanceListController attendanceListController;

private MockMvc mockMvc;

/**
* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.
*/

@BeforeEach
public void setup() {
mockMvc = MockMvcBuilders.standaloneSetup(attendanceListController).build();
}

/**
* テストメソッド kanggo displayAttendanceList() saka AttendanceListController.
*/

@Test
public void testDisplayAttendanceList() throws Exception {
mockMvc.perform(get("attendanceList"))
.andExpect(status().isOk())
.andExpect(model().attributeExists("attendanceList"))
.andExpect(view().name("attendanceList"));
}

}




























