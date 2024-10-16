<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항 목록</title>
</head>
<body>
    <h2>공지사항 목록</h2>

    <form action="/notice/list" method="get">
        <select name="category">
            <option value="">전체</option>
            <option value="일반">일반</option>
            <option value="오픈소식">오픈소식</option>
            <option value="서비스">서비스</option>
            <option value="당첨자발표">당첨자발표</option>
        </select>

        <input type="text" name="title" placeholder="제목 검색" />
        <input type="text" name="content" placeholder="내용 검색" />
        <button type="submit">검색</button>
    </form>

    <table border="1">
        <tr>
            <th>번호</th><th>카테고리</th><th>제목</th><th>등록일</th>
        </tr>
        <c:forEach var="notice" items="${notices}">
            <tr>
                <td>${notice.n_idx}</td>
                <td>${notice.n_category}</td>
                <td>${notice.n_title}</td>
                <td>${notice.n_regdate}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="/notice/write">공지사항 작성</a>
</body>
</html>
