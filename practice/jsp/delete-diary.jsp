<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
  <!--head-->
  <%@ include file="/html/head.html"%>

  <body>
    <!--header-->
    <%@ include file="/html/header.html"%>

    <main>
      <h2 align="center"><c:out value="${pageName}"/></h2>
      <p>削除しますか？</p>
      <form action="/practice/delete-diary" method="post">
        <table border="1">
          <tr>
            <th>タイトル</th>
            <td><c:out value="${diary.title}"/></td>
          </tr>
          <tr>
            <th>内容</th>
            <td><c:out value="${diary.content}"/></td>
          </tr>
        </table>
        <input type="hidden" name="diaryid" value="<c:out value="${diary.id}"/>">
        <br>
        <input type="submit" value="削除">
      </form>
      
      <br>
      <button onclick="location.href='/practice/list-diary'">一覧に戻る</button>
    </main>
  </body>

</html>