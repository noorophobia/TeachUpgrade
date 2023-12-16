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
        
        <div class="text-center">
        
         <img src="https://img.freepik.com/free-vector/school-classroom-interior-university-educational-concept-blackboard-table_1441-1694.jpg?w=1060&t=st=1682934827~exp=1682935427~hmac=c99c92fc403741cd1e553da18c3ddb90c962097dbc8c85a1940c929b3a8849a6" alt="avatar"
              class=" img-fluid" style="width: 1200px;">
          <div class="card-body">
           
            <p class="mb-4"><span class="text-primary font-bold me-1"> Classes Enrolled</span>  
                </p>
                
            <div class="row">
              <div class="col-sm-3">
               </div>
               
              <div class="col-sm-9">
                <p class="text-muted mb-0">   
               
                
                <ul class="dropdown" id="demolist" >
       
      <%
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "  SELECT Student_username,StudentListinclass.classid,classname,teacher_username FROM StudentListinclass left join class on StudentListinclass.classid=class.classid having Student_username=?";

  //to load driver
  String id= (String)session.getAttribute("username");
 
     		PreparedStatement st=con.prepareStatement(sql3);
     		st.setString(1, id);
	  System.out.print("classroom inside" +id);

   		ResultSet rs= st.executeQuery( );
   		//String classid=rs.getString("classid");
   	//	System.out.print("clasid                           :"+classid);
   //	  session.setAttribute("classid",classid);

          while(rs.next()){
        	    session.setAttribute("classid",rs.getString("classid"));
         	  %>
         	      
         	      
        	    <div class="row" >
              <div class="col-sm-3">
                <p class="mb-0"></p>
              </div>
              <div class="col-sm-9">
 </p>
              </div>
            </div>
            <hr>
            </ul>
        	  <div class="card" style="width: 18rem;">
  <div class="card-body ml" >
    <h5 class="card-title">Class Name</h5>
        <h6 class="card-subtitle mb-2 text-muted"onclick="location.href='StudentViewClass.jsp';"><a href="#"><%=rs.getString("classid") %></h6>
    
    <h6 class="card-subtitle mb-2 text-muted"onclick="location.href='StudentViewClass.jsp';"><a href="#"><%=rs.getString("className") %></h6>
     
    <p class="card-text" onclick="location.href='StudentViewClass.jsp';">CLass Teacher </p>
        <p class="card-text" onclick="location.href='StudentViewClass.jsp';"><%=rs.getString("teacher_username")%> </p>
    
    
  </div>
</div>
  
         	  
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