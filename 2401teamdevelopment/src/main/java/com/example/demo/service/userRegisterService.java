package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.userRegisterRequest;
import com.example.demo.entity.userRegister;
import com.example.demo.repository.userRegisterRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class userRegisterService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private userRegisterRepository userRegisterRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<userRegister> searchAll() {
    return userRegisterRepository.findAll();
  }

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
    public void create(userRegisterRequest userRegisterRequest) {
    userRegister user = new userRegister();
    user.setName(userRegisterRequest.getName());
    user.setFurigana(userRegisterRequest.getFurigana());
    user.setMail(userRegisterRequest.getMail());
    user.setPassword(userRegisterRequest.getPassword());

    userRegisterRepository.save(user);
  }
}