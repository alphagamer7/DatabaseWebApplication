<%-- 
    Document   : index
    Created on : Jul 6, 2017, 5:15:20 PM
    Author     : kosala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
         <form method="post" action="DatabseManager">
            <table>
                <tr><td>Name:</td><td><input type="text" name="name"></td></tr>
                <tr><td>ID:</td><td><input type="text" name="id"></td></tr>
                <tr><td></td><td><input type="submit" value="Enter a New Record"></td></tr>
            </table>
         </form>
        
    <BR>
        <table >
            <tr><a href="results.jsp">View All Records(Using JSP)</a></tr>
        </table>
        
        <form method="get" action="DatabseManager">
            <table>
                <tr><input type="submit" value="View All Records(Servlet and JSP)"></tr>
            </table>
        </form>
        
    </body>
</html>
