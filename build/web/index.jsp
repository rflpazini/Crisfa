<%-- 
    Document   : index
    Created on : 26/01/2015, 10:44:14
    Author     : pazini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward page="/PersonController?action=listperson" />
    </body>
</html>
