<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    
    <table align="center" border="1">
      <tr>
        <th rowspan="2">一行日記</th>
        <td><a href="/practice/list-diary">一覧</a></td>
      </tr>
      <tr>
        <td><a href="/practice/new-diary">投稿</a></td>
      </tr>
    </table>
  </body>

</html>