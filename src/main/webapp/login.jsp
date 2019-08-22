<%--
  Created by IntelliJ IDEA.
  User: marioj
  Date: 2019-08-21
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>


<form method="POST" action="login.jsp">
    <label for="username">Username</label>
    <input type="text" id="username" name="username">
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <button type="submit">Login</button>
</form>




<%--These are a few different ways to handle the same issue--%>
<%--This is using Expression language, this way is not transfer to servlets very well??--%>

<%--<c:if test="${param.username == 'admin' && param.password == 'password'}">--%>
<%--    <%response.sendRedirect("/profile.jsp");%>--%>
<%--</c:if>--%>
<%--<c:if test="${param.username != 'admin' && param.password != 'password'}">--%>
<%--    <p>Please Login</p>--%>
<%--</c:if>--%>



<%--This is using java syntax but in order for it to work you have to wrap it in <% %> you also need to to handle the NullException at the top.--%>

<%--<%--%>
<%--    if(request.getParameter("username") != null && request.getParameter("password") != null) {--%>
<%--        if (request.getParameter("username").equalsIgnoreCase("admin") && request.getParameter("password").equals("password")) {--%>
<%--            response.sendRedirect("/profile.jsp");--%>
<%--        } else {--%>
<%--            response.getWriter().write("Please try login again.");--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>


<%--OR, which is the best way--%>

<%
    if(request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equalsIgnoreCase("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<p>This always shows</p>

</body>
</html>