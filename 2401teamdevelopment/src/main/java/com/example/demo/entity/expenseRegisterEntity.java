package com.example.demo.entity;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "expense_tb",schema="public")
public class expenseRegisterEntity implements Serializable {
  /**
   * 経費ID
   */
  @Id
  @Column(name = "expense_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer expense_id;
  /**
   * ユーザーID
   */  
  @JoinColumn(name = "user_id")
  private Integer user_id;
  /**
   * 申請日
   */
  @DateTimeFormat(pattern = "application_date")
  private LocalDate application_date;
  /**
   * 経費項目
   */
  @Column(name = "category")
  private String category;
  /**
   * 金額
   */
  @Column(name = "amount")
  private Integer amount;
  /**
   * 備考
   */
  @Column(name = "remarks")
  private String remarks;
  

}
