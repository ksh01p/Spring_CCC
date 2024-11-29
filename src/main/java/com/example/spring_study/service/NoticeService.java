package com.example.spring_study.service;

import com.example.spring_study.domain.Board;
import com.example.spring_study.domain.Notice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface NoticeService {
    Map<String, Object> createNotice(Map<String, Object> params);
    Map<String, Object> updateNotice(Map<String, Object> params);
    Map<String, Object> deleteNotice(Integer id);
    List<Notice> listNotice();
    Notice detailNotice(Integer id);
}
