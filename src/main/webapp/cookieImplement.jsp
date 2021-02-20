<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Implementation</title>
</head>
<body>
<%
    String user = (String) session.getAttribute("email");
    String name = null;
    String sesID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("email")) name = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sesID = cookie.getValue();
        }
    }
%>
</body>
</html>
