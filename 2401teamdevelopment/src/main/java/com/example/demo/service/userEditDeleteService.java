package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.userEditDeleteUpdateRequest;
import com.example.demo.entity.userEditDelete;
import com.example.demo.repository.userEditDeleteRepository;



/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class userEditDeleteService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private userEditDeleteRepository userRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<userEditDelete> searchAll() {
    return userRepository.findAll();
  }

  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public userEditDelete findById(Long id) {
    return userRepository.findById(id).get();
  }

  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(userEditDeleteUpdateRequest userUpdateRequest) {
	userEditDelete user = findById(userUpdateRequest.getId());
    user.setName(userUpdateRequest.getName());
    user.setFurigana(userUpdateRequest.getFurigana());
    user.setMail(userUpdateRequest.getMail());
    user.setPassword(userUpdateRequest.getPassword());
    userRepository.save(user);
  }
  

  /**
   * ユーザー情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Long id) {
    userEditDelete user = findById(id);
    userRepository.delete(user);
  }
}