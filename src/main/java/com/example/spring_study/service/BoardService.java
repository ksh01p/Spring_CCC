package com.example.spring_study.service;

import com.example.spring_study.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface BoardService {
    Map<String, Object> createBoard(Map<String, Object> params);
    Map<String, Object> updateBoard(Map<String, Object> params);
    Map<String, Object> deleteBoard(Integer id);
    List<Board> listBoard();
    Board detailBoard(Integer id);
}
