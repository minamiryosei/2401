package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

/**
 * ユーザー情報 Enyity
 */
@Entity
@Data
@Table(name = "user_tb")
public class userRegister implements Serializable {
  /**
   * UserID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 名前
   */
  @Column(name = "name")
  private String name;
  /**
   * フリガナ
   */
  @Column(name = "furigana")
  private String furigana;
  /**
   * メールアドレス
   */
  @Column(name = "mail")
  private String mail;
  /**
   * パスワード
   */
  @Column(name = "password")
  private Date password;

}