package com.human.notice.service;

import java.util.List;
import com.human.notice.vo.NoticeVO;

public interface NoticeService {
    List<NoticeVO> searchNotices(String category, String title, String content);
    void addNotice(NoticeVO notice);
    List<NoticeVO> getNotices();
}
