<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항 작성</title>
</head>
<body>
    <h2>공지사항 작성</h2>

    <form action="/notice/write" method="post">
        <div>
            <label for="category">카테고리:</label>
            <select name="n_category" id="category" required>
                <option value="일반">일반</option>
                <option value="오픈소식">오픈소식</option>
                <option value="서비스">서비스</option>
                <option value="당첨자발표">당첨자발표</option>
            </select>
        </div>

        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="n_title" required placeholder="제목을 입력하세요" />
        </div>

        <div>
            <label for="content">내용:</label>
            <textarea id="content" name="n_content" rows="10" cols="50" required></textarea>
        </div>

        <div>
            <button type="submit">작성하기</button>
            <a href="/notice/list">목록으로</a>  <!-- 공지사항 목록으로 이동 -->
        </div>
    </form>
</body>
</html>
