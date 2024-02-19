package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user_tb")
public class UserListEntity implements Serializable {
  /**
   * ユーザーID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;
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
  private String password;
}