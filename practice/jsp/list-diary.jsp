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
      <h2 align="center">一覧</h2>
      <br>
      
      <button onclick="location.href='/practice/new-diary'">新しい一言日記</button>
      <br>
      
      <c:forEach items="${diaryList}" var="diary">
        <ul>
          <table border="1">
            <tr>
              <td><c:out value="${diary.title}"/></td>
              <td><c:out value="${diary.date}"/></td>
              <td>
                <form action="/practice/update-diary" method="get">
                  <input type="hidden" name="diaryid" value="<c:out value="${diary.id}"/>">
                  <input type="submit" value="更新">
                </form>
              </td>
              <td>
                <form action="/practice/delete-diary" method="get">
                  <input type="hidden" name="diaryid" value="<c:out value="${diary.id}"/>">
                  <input type="submit" value="削除">
                </form>
              </td>
            </tr>
            <tr>
              <td colspan="4"><c:out value="${diary.content}"/></td>
            </tr>
          </table>
        </ul>
      </c:forEach>
      
      <br>
      <button onclick="location.href='/practice'">トップへ戻る</button>
    </main>
  </body>

</html>
