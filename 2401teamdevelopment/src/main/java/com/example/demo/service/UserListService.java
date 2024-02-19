package com.example.demo.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserListRequest;
import com.example.demo.entity.UserListEntity;
import com.example.demo.repository.UserListRepository;
/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserListService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserListRepository userRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  
  /**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public UserListEntity findById(Long id) {
		//実装1行
		return userRepository.findById(id).get();

	}
  public List<UserListEntity> searchAll() {
    return userRepository.findAll();
  }
  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UserListRequest UserListRequest) {
    Date now = new Date();
    UserListEntity user = new UserListEntity();
   
    user.setName(UserListRequest.getName());
    user.setFurigana(UserListRequest.getFurigana());
    user.setMail(UserListRequest.getMail());
    user.setPassword(UserListRequest.getPassword());
    
    userRepository.save(user);
  }
}