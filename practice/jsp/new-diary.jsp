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
      <h2 align="center">新規</h2>
      <form action="/practice/new-diary" method="post">
        <table>
          <tr>
            <th>タイトル</th>
            <td><input type="text" name="title" size="20"></td>
          </tr>
          <tr>
            <th>内容</th>
            <td><input type="text" name="content" size="60"></td>
          </tr>
        </table>
        <input type="submit" value="登録">
      </form>
      
      <br>
      <button onclick="location.href='/practice/list-diary'">一覧へ戻る</button>
    </main>
  </body>

</html>