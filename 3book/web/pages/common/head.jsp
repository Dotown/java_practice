<%--
  Created by IntelliJ IDEA.
  User: Zhang
  Date: 2021/3/29
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url = request.getScheme() +
            "://" +
            request.getServerName() +
            ":" +
            request.getServerPort() +
            request.getContextPath() +
            "/";
%>
<base href=<%=url%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
