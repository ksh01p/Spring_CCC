package com.example.spring_study.service.impl;

import com.example.spring_study.domain.Board;
import com.example.spring_study.domain.Notice;
import com.example.spring_study.repository.NoticeRepository;
import com.example.spring_study.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(
            NoticeRepository noticeRepository
    ) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Map<String, Object> createNotice(Map<String, Object> params) {
        System.out.println("createBoard");
        Notice notice = new Notice();
        notice.setId(Integer.parseInt(params.get("id") + ""));
        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());
        notice.setWriter(params.get("writer").toString());
        noticeRepository.save(notice);
        return null;
    }

    @Override
    public Map<String, Object> updateNotice(Map<String, Object> params) {
        System.out.println("updateBoard");
        Notice notice = noticeRepository.findById(params.get("id") + "").orElseThrow(() -> new RuntimeException(""));

        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());
        notice.setWriter(params.get("writer").toString());
        noticeRepository.save(notice);
        return null;
    }
    @Override
    public List<Notice> listNotice() {
        return noticeRepository.findAll();
    }
    @Override
    public Notice detailNotice(Integer id) {
        return noticeRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> deleteNotice(Integer id) {
        Notice notice = noticeRepository.findById(Integer.toString(id)).orElseThrow(() -> new RuntimeException(""));
        noticeRepository.delete(notice);
        return null;
    }
}
