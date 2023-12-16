<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style> 
 body {
     display: flex;
     align-items: center;
     justify-content: center;
     margin: 0 auto;
     height: 100vh; 
     background-color: #f1f1f1;
   }
   </style>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
  $(document).ready(function () {
    $('#demolist a').on('click', function () {
       alert("Your Favourite Sports is "+txt);
    });
  });
</script>
<body>
  <form action="login" method="post"> 
     
      <ul class="dropdown" id="demolist" >
        <button class="dropbtn">Dropdown</button>
      
      <%
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/noor","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "SELECT * FROM category ORDER BY name";
  //to load driver
    		PreparedStatement st=con.prepareStatement(sql3);
   		ResultSet rs= st.executeQuery( );
          while(rs.next()){
        	  %>
        	    <li><a href="#"><%=rs.getString("name") %></a></li>
        	  
        	  <%
          
          }}
catch(Exception e){}
%>
  
         </form>
   
  </body>
</html>