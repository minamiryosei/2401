
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LeavingRegisterentity;

@Repository
public interface LeavingRegisterrepository extends JpaRepository<LeavingRegisterentity,Integer>{}