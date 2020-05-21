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
      <br>
      
      <form action="/practice/update-diary" method="post">
        <table>
          <tr>
            <th>タイトル</th>
            <td><input type="text" size="20" name="title" autocomplete="off" value="<c:out value="${diary.title}"/>"></td>
          </tr>
          <tr>
            <th>内容</th>
            <td><input type="text" size="60" name="content" autocomplete="off" value="<c:out value="${diary.content}"/>"></td>
          </tr>
        </table>
        <input type="hidden" name="diaryid" value="<c:out value="${diary.id}"/>">
        <input type="hidden" name="date" value="<c:out value="${diary.date}"/>">
        <input type="submit" value="<c:out value="${pageName}"/>">
      </form>
    </main>
    
    <br>
    <button onclick="location.href='/practice/list-diary'">一覧に戻る</button>
  </body>

</html>