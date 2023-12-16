<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmed</title>
<link href="mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
       String address1 = request.getParameter("username");
   session.setAttribute("address1", address1);
         String address2 = request.getParameter("password");
     session.setAttribute("address2", address2);
  String address3 = request.getParameter("Address3");
     session.setAttribute("address3", address3);
     %>
   <form action="result.jsp" method="post">
  <table border="0" cellpadding="0" cellspacing="0" height="30%" width="50%">
      <tr bgcolor="#FBFBFB">
      <td><B>Description:</B><br><textarea name="description" rows="12"  
      cols="50"colspan="2"></textarea>
      </td>
      </tr>
      <tr bgcolor="#FBFBFB">
      <td colspan="2"><input type="submit" value="Finished" /></td>
      </tr>
</table>
</form>
</body>
</html>