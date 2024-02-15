package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class userEditDeleteRequest implements Serializable {
	 /**
	   * 名前
	   */
	  @NotEmpty(message = "名前を入力してください")
	  private String name;
	  /**
	   * 住所
	   */
	  @NotEmpty(message = "フリガナを入力してください")
	  @Pattern(regexp = "^[ァ-ヶー　]*$", message = "全角カタカナで入力してください")
	  private String furigana;
	  /**
	   * 住所
	   */
	  @NotEmpty(message = "メールアドレスを入力してください")
	  @Email(message = "メールアドレスの形式に入力してください。")
	  private String mail;
	  /**
	   * 住所
	   */
	  @NotEmpty(message = "パスワードを入力してください")
	  @Size(min = 8, message = "パスワードは8桁以上で入力してください")
	  private String password;
	}