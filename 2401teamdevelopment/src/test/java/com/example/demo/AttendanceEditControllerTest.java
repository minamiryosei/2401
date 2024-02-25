package com.example.demo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.AttendanceEditController;
import com.example.demo.dto.AttendanceEditRequest;
import com.example.demo.service.AttendanceEditService;



/**
* テストクラス kanggo AttendanceEditController.
*/

@WebMvcTest(AttendanceEditController.class)
public class AttendanceEditControllerTest {

@MockBean
AttendanceEditService attendanceEditService;

@Autowired
private AttendanceEditController attendanceEditController;

private MockMvc mockMvc;


/**
* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.
*/
@BeforeEach
public void setup() {
mockMvc = MockMvcBuilders.standaloneSetup(attendanceEditController).build();
}

/**
* テストメソッド kanggo displayAttendanceEdit() saka AttendanceEditController.
*/

@Test
public void testDisplayAttendanceEdit() throws Exception {
mockMvc.perform(get("attendanceEdit"))
.andExpect(status().isOk())
.andExpect(model().attributeExists("attendanceEditRequest"))
.andExpect(view().name("attendanceEdit"));
}

/**
* テストメソッド  attendanceEditUpdate() 正常系テスト
*/

@Test
public void testUpdateAttendanceEditSucess() throws Exception {
AttendanceEditRequest testRequest = new AttendanceEditRequest();
testRequest.setUser_id(2);
testRequest.setStatus("出勤");
testRequest.setGoing_date(2024/02/19);
testRequest.setGoing_time(09:00);
testRequest.setLeaving_date(2024/02/19);
testRequest.setLeaving_time(19:00);
testRequest.setWorking_time(09:00);
testRequest.setBreak_time("01:00");
testRequest.setEdit_reason("申告漏れ");
testRequest.setRemarks("休日出勤");

mockMvc.perform((post("/attendanceEdit/update")).flashAttr("attendanceEditRequest", testRequest))
.andExpect(model().hasNoErrors())
.andExpect(model().attribute("attendanceEditRequest", testRequest))
.andExpect(view().name("redirect:/attendanceEdit/%d/edit"));
verify(attendanceEditService, times(1)).update(testRequest);
//verify([モックオブジェクト], times([回数])).[テストするメソッド]([引数]);
}

/**
*  テストメソッド attendanceEditUpdate() 異常系テスト
*/

@Test
public void testUpdateAttendanceEditError() throws Exception {
AttendanceEditRequest testRequest = new AttendanceEditRequest();
testRequest.setUser_id(null);
testRequest.setStatus("");
testRequest.setGoing_date(null);
testRequest.setGoing_time(null);
testRequest.setLeaving_date(null);
testRequest.setLeaving_time(null);
testRequest.setWorking_time(null);
testRequest.setBreak_time(null);
testRequest.setEdit_reason("");
testRequest.setRemarks("");

mockMvc.perform((post("/attendanceEdit/update")).flashAttr("attendanceEditRequest", testRequest))
.andExpect(model().hasErrors())
.andExpect(model().attribute("attendanceEditRequest",testRequest))
.andExpect(view().name("attendanceEdit"));
}

}
