package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報 Repository
 */
@userRepository
public interface userRegisterRepository extends JpaRepository<userRegister, Long> {}