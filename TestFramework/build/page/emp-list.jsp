<%-- 
    Document   : emp-list
    Created on : 24 mars 2023, 11:41:53
    Author     : maroussia
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="modele.Emp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //out.println(request.getAttributeNames());
   
    Emp emp = (Emp)request.getAttribute("liste");
   
    Vector<Emp> empl = (Vector<Emp>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLOYE</title>
    </head>
    <body>
        <h1>Hello World!</h1>       
        <a href="http://localhost:8080/TestFramework/getEmp?nom=<% out.println(emp.getName()); %>">  <% out.println(emp.getName()); %> </a>
        <% 
            for (int idx = 0; idx < empl.size(); idx++) {
                    out.println("<p>"+ empl.get(idx).getName()+"</p>" );
                    
                }
        %>
    </body>
</html>
