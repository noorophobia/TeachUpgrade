<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
  <%@page import="javax.servlet.http.HttpSession"%>
   <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
 <%@page import="java.io.InputStream"%>
<%@page import="login.*"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



      
      <%
try{ 
	
	
	int id= (int)session.getAttribute("lec");
	System.out.print("lecTureid: "+id);

    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "SELECT * FROM videos where lectureid=?";
  //to load driver
  
     
    		PreparedStatement st=con.prepareStatement(sql3);
   		ResultSet rs= st.executeQuery(sql3);
          while(rs.next()){
              InputStream inputStream = null;
 
             // rs = st.executeQuery();
           if (rs.next()) {
               inputStream = rs.getBinaryStream("video");
           }
        	  %>
        	  <video width="640" height="360" controls>
        	  
   <source src=<%=rs.getBinaryStream("video")%> <% 
          response.setContentType("video/mp4");

   byte[] buffer = new byte[4096];
            int bytesRead = -1;
            if (inputStream != null) {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
                
 
            }
  %>
  type="video/mp4">
         	  
        	 
        	  
        	  <%
          
          }}
catch(Exception e){}
%>


</body>
</html>