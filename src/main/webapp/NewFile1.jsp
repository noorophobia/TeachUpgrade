<%@page import="javax.servlet.http.Cookie"%>
<html>
    <head>
        <title>JSP Read Cookie</title>
    </head>
    <body>
        <%
 
String p=request.getParameter("username");
String up = (String)session.getAttribute("username");
Student s = (Student)session.getAttribute("user");


  System.out.print("nsett"+up);
 
 System.out.print("nsett"+p);



%>
    </body>
</html>