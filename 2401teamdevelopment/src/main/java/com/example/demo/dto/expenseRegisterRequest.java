package com.example.demo.dto;
import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class expenseRegisterRequest implements Serializable {
	
 
  /**
   * ユーザーID
   */
  @NotNull(message = "ユーザーIDを入力してください")
  private Integer user_id;
  /**
   * 申請日
   */
  @NotNull(message = "申請日を入力してください")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy/MM/dd") 
  private LocalDate application_date;
  
  /**
   * 経費項目
   */
  @NotEmpty(message = "経費項目を入力してください")
  @Size(max=20,message="20文字以下で入力してください")
  private String category;
  /**
   * 金額
   */
  @NotNull(message = "金額を入力してください")
  private Integer amount;
  /**
   * 備考
   */
  @Length(max=100,message="100文字以下で入力してください")
  private String remarks;
}
 