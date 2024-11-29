package com.example.spring_study.service.impl;

import com.example.spring_study.domain.Board;
import com.example.spring_study.repository.BoardRepository;
import com.example.spring_study.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    public BoardServiceImpl(
            BoardRepository boardRepository
    ) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Map<String, Object> createBoard(Map<String, Object> params) {
        System.out.println("createBoard");
        Board board = new Board();
        board.setId(Integer.parseInt(params.get("id") + ""));
        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        board.setAuthor(params.get("author").toString());
        boardRepository.save(board);
        return null;
    }

    @Override
    public Map<String, Object> updateBoard(Map<String, Object> params) {
        System.out.println("updateBoard");
        Board board = boardRepository.findById(params.get("id") + "").orElseThrow(() -> new RuntimeException(""));

        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        board.setAuthor(params.get("author").toString());
        boardRepository.save(board);
        return null;
    }
    @Override
    public List<Board> listBoard() {
        return boardRepository.findAll();
    }
    @Override
    public Board detailBoard(Integer id) {
        return boardRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> deleteBoard(Integer id) {
        Board board = boardRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
        boardRepository.delete(board);
        return null;
    }
}
