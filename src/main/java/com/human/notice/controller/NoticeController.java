package com.human.notice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // 공지사항 목록 페이지 매핑 (검색 포함)
    @GetMapping("/list")
    public String noticeList(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            Model model) {

        // 검색 조건에 따라 공지사항 목록 조회
        List<NoticeVO> notices = noticeServiceImpl.searchNotices(category, title, content);
        model.addAttribute("notices", notices);
        model.addAttribute("category", category);
        model.addAttribute("title", title);
        model.addAttribute("content", content);

        return "notice/notice_list";  
    }

    // 공지사항 작성 폼 페이지로 이동
    @GetMapping("/write")
    public String writeForm() {
        return "notice/notice_write";  
    }

    // 공지사항 작성 처리
    @PostMapping("/write")
    public String writeNotice(NoticeVO notice) {
        noticeServiceImpl.addNotice(notice);  
        return "redirect:/list";  
    }

   
}
