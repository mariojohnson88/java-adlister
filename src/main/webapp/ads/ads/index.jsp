<%--
  Created by IntelliJ IDEA.
  User: marioj
  Date: 2019-08-23
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Ads</title>
</head>
<body>


<h1>Here are your ads</h1>

<c:forEach var = "ad" items="${ads}">
    <li>
        <div>${ad.title}</div>
        <p>${ad.description}</p>
    </li>
</c:forEach>

</body>
</html>
