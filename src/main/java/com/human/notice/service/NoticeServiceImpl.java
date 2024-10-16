package com.human.notice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.human.notice.repository.NoticeDAO;
import com.human.notice.vo.NoticeVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;

    @Override
    public List<NoticeVO> searchNotices(String category, String title, String content) {
        return noticeDAO.searchNotices(category, title, content);
    }

    @Override
    public void addNotice(NoticeVO notice) {
        noticeDAO.insertNotice(notice);
    }

    @Override
    public List<NoticeVO> getNotices() {
        return noticeDAO.getNotices();  
    } 
}
