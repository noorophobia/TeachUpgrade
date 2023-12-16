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
<body>
<form action="sit" method="post"> 
<label>Enrolled Classes </label>
<select name="point">
<option> select</option>
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
        	  <option><%=rs.getString("name") %></option>
        	  
        	  <%
          
          }}
catch(Exception e){}
%>
      <input type="submit" value="Go to Class" />
      
      
      

</form>
</select>
</body>
</html>