package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.expenseRegisterRequest;
import com.example.demo.entity.expenseRegisterEntity;
import com.example.demo.repository.expenseRegisterRepository;
/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class expenseRegisterService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private expenseRegisterRepository expenseRegisterRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<expenseRegisterEntity> searchAll() {
    return expenseRegisterRepository.findAll();
  }
  

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(expenseRegisterRequest expenseRegisterRequest) {
    expenseRegisterEntity expenseRegister = new expenseRegisterEntity();
    expenseRegister.setUser_id(expenseRegisterRequest.getUser_id());
    expenseRegister.setApplication_date(expenseRegisterRequest.getApplication_date());
    expenseRegister.setCategory(expenseRegisterRequest.getCategory());
    expenseRegister.setAmount(expenseRegisterRequest.getAmount());
    expenseRegister.setRemarks(expenseRegisterRequest.getRemarks());
    
    expenseRegisterRepository.save(expenseRegister);
  }

}