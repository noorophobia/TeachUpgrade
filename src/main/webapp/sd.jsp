<%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
 <title>M profile</title>
    
    <style>
     .bg-1 { 
    background-color: #1abc9c; /* Green */
    color: #ffffff;
  }
    
      
       .container-fluid {
    padding-top: 70px;
    padding-bottom: 70px;
  }
 
    
     
    </style>
  </head>
</head>
<!-- - <body style="background-color:white;">  -->
<body> 
<body>
<form action="main" method="post"> 
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">teachUpgrade</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="HomePage.jsp">Home</a>
        </li>
 
        </li>
         <li class="nav-item">
          <a class="nav-link" href="Classroom.jsp">Classroom</a>
        </li>
                  <li class="nav-item">
          <a class="nav-link" href="Contact.jsp">Contact us</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="About">About</a>
        </li>
        <li class="nav-item">
         </li>
      </ul>
      <li>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      </li>
    </div>
  </div>
</nav>


    <div class="row">
    
       
    
</section>
    </body>
    
</html>






<%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 <%@page import="javax.servlet.http.HttpSession"%>
 
<%@page import="login.*"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
    <title> Settings</title>
   
</head>
<body>
 
 <!-- Navbar -->
 
     
 <div class="container">
<div class="row justify-content-center">
    <div class="col-12 col-lg-10 col-xl-8 mx-auto">
        <h2 class="h3 mb-4 page-title">Settings</h2>
        <div class="my-4">
            <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="home-tab"   onclick="location.href='MyProfile.jsp';"  data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">My Profile</a>
                </li>
            </ul>
                  <form action="SettingServlet" method="post"> 
                 
                                 <button type="submit" name="changeusername" class="btn btn-primary"> Change Username</button>
                                 <button type="submit" class="btn btn-primary">Change  Password</button>
                                 <button type="submit" class="btn btn-primary">Help</button>
                 
                 
                    
                
                 <div>${userMessage}</div>
    <div style="color:red">${errorMessage}</div>
        <div style="color:green">${success}</div>
     
            </form>
        </div>
    </div>
</div>
<%
 
//To retrieve the attribute from the session object
String id= (String)session.getAttribute("username");
  



%>
</div>
</body>
</html>