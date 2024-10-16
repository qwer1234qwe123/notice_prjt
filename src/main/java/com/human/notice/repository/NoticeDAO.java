package com.human.notice.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.notice.vo.NoticeVO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class NoticeDAO {

    private final SqlSession sqlSession;
    private static final String MAPPER = "com.human.notice.repository.NoticeDAO";

    // 검색 기능 구현
    public List<NoticeVO> searchNotices(String category, String title, String content) {
        Map<String, Object> param = new HashMap<>();
        param.put("category", category);
        param.put("title", title);
        param.put("content", content);

        return sqlSession.selectList(MAPPER + ".searchNotices", param);
    }

    public void insertNotice(NoticeVO notice) {
        sqlSession.insert(MAPPER + ".insertNotice", notice);
    }

    public List<NoticeVO> getNotices() {
        return sqlSession.selectList(MAPPER + ".getNotices");
    }
}
