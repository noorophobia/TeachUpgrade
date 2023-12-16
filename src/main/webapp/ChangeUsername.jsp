<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 <%@page import="javax.servlet.http.HttpSession"%>
 
<%@page import="login.*"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
  <hr class="my-4" />
                    <form action="ChangeSettings" method="get"> 
  
                <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label >Old username</label>
                            <input type="text" class="form-control" name="usernames" />
                        </div>
                        <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label >New username</label>
                            <input type="text" class="form-control" name="usernames1" />
                        </div>
                <button type="submit" class="btn btn-primary">Save Change</button>
                 <div>${userMessage}</div>
    <div style="color:red">${errorMessage}</div>
        <div style="color:green">${success}</div>
       
       </form>
       <%
       String id=(String)session.getAttribute("username");
      session.setAttribute("id", id); 
        
 
       %>
</body>
</html>