 




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<!DOCTYPE html>
<html>
 <head>
 </head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

     <title>Classroom</title>
    
    <style>
     .bg-1 { 
    background-color: #1abc9c; /* Green */
    color: #ffffff;
  }
    
      
       .container-fluid {
    padding-top: 70px;
    padding-bottom: 70px;
  }
  .navbar {
    padding-top: 15px;
    padding-bottom: 15px;
    border: 0;
    border-radius: 0;
    margin-bottom: 0;
    font-size: 12px;
    letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
    color: #1abc9c !important;
  }
     
    </style>
  </head>
</head>
<!-- - <body style="background-color:white;">  -->
<body> 
  
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#">teachUpgrade</a></li>
         
      </ul>
    </div>
  </div>
</nav>
 
 <body>  
 <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
           WELCOME HO CLASSROOM
              
            </div>
          </div>
        </div>
       
          <div class="card-body">
           
            <p class="mb-4"><span class="text-primary font-bold me-1"> Classes Enrolled</span>  
                </p>
                
            <div class="row">
              <div class="col-sm-3">
               </div>
               
              <div class="col-sm-9">
                <p class="text-muted mb-0">   <ul class="dropdown" id="demolist" >
       
      <%
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "SELECT lecTureid FROM videos  ";
  //to load driver
    		PreparedStatement st=con.prepareStatement(sql3);
    

   		ResultSet rs= st.executeQuery( );
   	   
          while(rs.next()){
        	  %>
        	    <li onclick="location.href='Class.jsp';"><a href="#"><%=rs.getInt("lecTureid")  %></a></li>
         	  
        	  <%
          
          }}
catch(Exception e){}
     	  
%>
               
                </p>
              </div>
            </div>
            <hr>
        
      	      	    <div style="color:Green">${errorMessage}</div>
          
</body>
</html>

