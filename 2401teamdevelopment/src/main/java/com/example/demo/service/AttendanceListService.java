package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.repository.AttendanceListRepository;

/**
 * 勤怠一覧 Service
 */
@Service
public class AttendanceListService {

  /**
   * 勤怠一覧 Repository
   */
  @Autowired
  private AttendanceListRepository attendanceListRepository;

  /**
   * 勤怠一覧 全検索
   * @return 検索結果
   */
  public List<AttendanceListEntity> searchAll() {
    return attendanceListRepository.findAll();
  }
}