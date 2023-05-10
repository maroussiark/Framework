<%-- 
    Document   : save
    Created on : 2 mai 2023, 10:41:34
    Author     : maroussia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println(request.getAttribute("nom"));
        %>
    </body>
</html>
