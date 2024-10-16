package com.human.notice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.human.notice.service.NoticeService;
import com.human.notice.vo.NoticeVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/")  // 모든 /notice 경로 처리
public class NoticeController {

    private final NoticeService noticeServiceImpl;

    // 루트 또는 /notice 경로로 접근 시 /notice/list로 리다이렉트
    @GetMapping({"", "/"})
    public String redirectToNoticeList() {
        return "redirect:/list";  // /notice/list로 리다이렉트
    }

    // 공지사항 목록 페이지 매핑
    @GetMapping("/list")
    public String noticeList(Model model) {
        List<NoticeVO> notices = noticeServiceImpl.getNotices();  // 공지사항 목록 조회
        model.addAttribute("notices", notices);  // 조회된 공지사항 목록을 Model에 추가
        return "notice/notice_list";  // /WEB-INF/views/notice/notice_list.jsp로 이동
    }

    // 공지사항 작성 폼 페이지로 이동
    @GetMapping("/write")
    public String writeForm() {
        return "notice/notice_write";  // /WEB-INF/views/notice/notice_write.jsp로 이동
    }

    // 공지사항 작성 처리
    @PostMapping("/write")
    public String writeNotice(NoticeVO notice) {
        noticeServiceImpl.addNotice(notice);  // 공지사항 추가
        return "redirect:/list";  // 작성 후 목록 페이지로 리다이렉트
    }

   
}
