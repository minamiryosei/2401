package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserListRequest implements Serializable {
	
  /**
   * 名前
   */
  
  private String name;
  /**
   * フリガナ
   */
  
  private String furigana;
  /**
   * メールアドレス
   */
 
  private String mail;
  /**
   * パスワード
   */
  
  private String password;
  
  /**
   * 編集
   */
  
  /**
   * 戻る
   */
}