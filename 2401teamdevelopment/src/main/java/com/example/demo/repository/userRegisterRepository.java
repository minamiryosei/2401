package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.userRegister;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface userRegisterRepository extends JpaRepository<userRegister, Long> {}