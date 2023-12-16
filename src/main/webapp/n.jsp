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
                 
                 
                <hr class="my-4" />
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstname">Firstname</label>
                        <input type="text" id="firstname1" class="form-control" placeholder="John" />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastname">Lastname</label>
                        <input type="text" id="lastname1" class="form-control" placeholder="Doe" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="email1" placeholder="**@gmail.com" />
                </div>
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCompany5">Username</label>
                        <input type="text" class="form-control" id="username1" placeholder="johnx2" />
                                                                                 <button type="submit" name="use"class="btn btn-primary">  Change username </button>
                        
                    </div>
                     
			</div>
                     

                    <div class="form-group col-md-4">
                        <label for="category">Student Type</label>
                        <select id="category1" class="form-control">
                            <option selected="">Select </option>
                            <option>Middle School Student</option>
					<option>High School Student</option>
										<option>Undergraduate</option>
										<option>PostGraduate</option>
                         </select>
                    </div>
                                     <button type="submit" name="cat"class="btn btn-primary">  Change Category </button>
                     
                <hr class="my-4" />
                <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="inputPassword4">Old Password</label>
                            <input type="password" class="form-control" id="oldpassword" />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword5">New Password</label>
                            <input type="password" class="form-control" id="newpassword" />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword6">Confirm Password</label>
                            <input type="password" class="form-control" id="newpassword1" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <p class="mb-2">Password requirements</p>
                        <p class="small text-muted mb-2">To create a new password, you have to meet all of the following requirements:</p>
                        <ul class="small text-muted pl-4 mb-0">
                            <li>Minimum 6 character</li>
                             <li>At least one number</li>
                         </ul>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save Change</button>
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
 
 
 System.out.print("id: "+id);



%>
</div>
</body>
</html>