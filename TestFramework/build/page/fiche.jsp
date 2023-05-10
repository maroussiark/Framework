<%-- 
    Document   : fiche
    Created on : 2 mai 2023, 10:41:34
    Author     : maroussia
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="modele.Emp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //out.println(request.getAttributeNames());
   
    Emp emp = (Emp)request.getAttribute("emp");
   
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println(emp.getName());
        %>
    </body>
</html>