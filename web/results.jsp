<%-- 
    Document   : results
    Created on : Jul 6, 2017, 5:51:19 PM
    Author     : kosala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results Page</title>
    </head>
    <body>
    <%
        try{
                Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/myData");
                Statement statement = cn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM student");
                while (rs.next()) {
                   out.println( rs.getString("name")+" - " + rs.getString("id") + "<BR>");
                }
                
                //housekeeping
                cn.close();
                rs.close();
            }
           catch(Exception e){
                System.out.print(e);
       }
        
    %>    
    <BR>
     <a href="home.jsp">Go Back to Home Page </a> 
     
    </body>
</html>
