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
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>My Profile</title>
   <style>
  
  </style>
</head>
<body>
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
 
 
 <body>  
 <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
           WELCOME TO CLASSROOM
              
            </div>
          </div>
        </div>
        </div>
        
        
           <%  String id= (String)session.getAttribute("classid");
	  System.out.print("class id in class.jsp"+id);
	  session.setAttribute("id",id);
	  
	  %>
        
        <div class="text-center">
        
         <img src="https://img.freepik.com/free-vector/school-classroom-interior-university-educational-concept-blackboard-table_1441-1694.jpg?w=1060&t=st=1682934827~exp=1682935427~hmac=c99c92fc403741cd1e553da18c3ddb90c962097dbc8c85a1940c929b3a8849a6" alt="avatar"
              class=" img-fluid" style="width: 1200px;">
          <div class="card-body">
           
       <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
                                                                                                          Upload Video              
            </div>
          </div>
        </div>
        </div>
        
        <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
                    <div class="form-group col-md-4">
                         <select id="selectclassid" class="form-control">
                             <option><%=(String)session.getAttribute("classid")%></option>
			 
                         </select>
                    </div>
                </p>
                             <div class="form-group col-md-4">
                         <select id="selectuser" class="form-control">
                             <option><%=(String)session.getAttribute("username")%></option>
			 
                         </select>
                    </div>
                </p>
                         
           
                </p>
                                                                               <form action="UploadServlet" method="post" enctype="multipart/form-data">
                                                                        <p class="mb-4"><span class="text-primary font-bold me-1"> Select video to upload:
</span>  
 
                                                                                    <input type="file" name="videoFile"><br>
 
 
                                                                                         <h5 class="card-title">Video Title:
                                                                                                                                  </h5>
 <input type="text" name="title"><br>
     
   <h6 class="card-title"> Video Description:
   :
                                        </h6>
 <textarea name="description" rows="3" cols="40"></textarea><br>
 </br>
<input type="submit" class="btn btn-primary" value="Upload" name="submit">
</form>
 
                
            <div class="row">
              <div class="col-sm-3">
               </div>  </div>
          </div>
        </div>
        </div>
                <%if(request.getAttribute("upload")!=null){
                	
                    request.getRequestDispatcher("class1.jsp").forward(request, response);

                }
                	%>
                
                 
            <div class="row">
              <div class="col-sm-3">
               </div>
               
              <div class="col-sm-9">
                <p class="text-muted mb-0">  
                
 

</body>
</html>
