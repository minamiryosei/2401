package com.example.demo.request;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class goingRegisterrequest {

＠Notempty（message=	"ユーザーIDを入力してください")
private String Attendance_id;

＠Notempty（message=	"ステータスの選択をしてください"）
private String Status;

＠Notempty（message=	"出勤日の選択をしてください”）
private String goingday;
	
＠Notempty（message=	"出勤時間を入力してください”）
private String goingtime;

}

