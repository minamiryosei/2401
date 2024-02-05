package com.example.demo.userRegisterRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/**
 * ユーザー情報 Repository
 */
@userRegisterRepository
public interface userRegisterRepository extends JpaRepository<User, Long> {}