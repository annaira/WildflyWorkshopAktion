<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="time" scope="application" class="time.TimeBean" />

<html>
    <head>
        <title>Actual Time</title>
    </head>
    <body>
        <h1>JSP: <jsp:getProperty name="time" property="time"/></h1>
    </body>
</html>