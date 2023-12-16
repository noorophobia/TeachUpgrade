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
                                        <a class="nav-link active" id="home-tab"   onclick="location.href='ChangePassword.jsp';"  data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Change Password</a>
                    
                </li>
            </ul>
                  <form action="SettingServlet" method="post"> 
                 
  
                                 <button type="submit" name="changeusername" class="btn btn-primary"> Change Username</button>
                                  <button type="submit"name="changepass" class="btn btn-primary">Change  Password</button>
                                  </br>
                                  </br>
                                  </br>
                                 <button type="submit" class="btn btn-primary">Help</button>
                                 <button type="submit" name="dele" class="btn btn-primary">Delete Account</button>
                                 
                 
                 
                    
                
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