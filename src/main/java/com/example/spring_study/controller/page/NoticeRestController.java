package com.example.spring_study.controller.page;
import com.example.spring_study.domain.Board;
import com.example.spring_study.domain.Notice;
import com.example.spring_study.service.BoardService;
import com.example.spring_study.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {

    private final NoticeService noticeService;
    public NoticeRestController(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }

    //List<Map<String, Object>> boardList = new ArrayList<>();
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return noticeService.createNotice(params);
        /*
        이전에 컨트롤러 필드에 저장해보는 코드

        String title = (String) params.get("title");
        String content = params.get("content") + "";
        String author = params.get("author") + "";
        int order = boardList.size();

        Map<String, Object> boardMap = new HashMap<>();
        boardMap.put("order", ++order);
        boardMap.put("title", title);
        boardMap.put("content", content);
        boardMap.put("author", author);
        boardList.add(boardMap);

        System.out.println(boardList);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        */
    }
    @GetMapping("/list")
    public List<Notice> list(){
        return noticeService.listNotice();
        //return boardList;
    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Notice detail(@RequestParam Integer id){
        return noticeService.detailNotice(id);
        /*int index = Integer.parseInt(order) - 1;
        Map<String, Object> boardMap = boardList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        resultMap.put("detail_board", boardMap);
        return resultMap;
        */

    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        /*
        int index = Integer.parseInt(params.get("order") + "") - 1;
        Map<String, Object> boardMap = boardList.get(index);
        boardMap.put("title", params.get("title"));
        boardMap.put("content", params.get("content"));
        boardMap.put("author", params.get("author"));
        //boardList.add

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        //resultMap.put("detail_board", boardMap);

        return resultMap;
        */
        return noticeService.updateNotice(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return noticeService.deleteNotice(Integer.parseInt(params.get("id") + ""));
    }


}