<%--
  Created by IntelliJ IDEA.
  User: marioj
  Date: 2019-08-21
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>

<%--Below is the JSP directive, it is used to specify the content type of this page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Code inside of <%! %> will be treated as an instance variable definition.--%>
<%! int counter = 0; %>
<%--The <% %> tags allow us to evaluate arbitrary Java code, and can potentially even contain multiple statements.--%>
<% counter += 1; %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="/partials/navbar.jsp"%>

<h1>Welcome to my Mario's JSP practice site</h1>

<h1>The current count is <%= counter %>.</h1>

View the page source!
<%-- this is a JSP comment, you will *not* see this in the html --%>
<!-- this is an HTML comment, you *will* see this in the html -->

<h1>Welcome To The Site!</h1>
<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: <%= request.getParameter("name") %></p>
<p>User-Agent header: <%= request.getHeader("user-agent") %></p>


</body>
</html>
