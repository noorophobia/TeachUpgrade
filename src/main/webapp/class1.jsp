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
    .ml {
  background-color: rgba(0, 0, 0, 0.2);
}
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
<% 

String title = request.getParameter("title");
String description = request.getParameter("description");
String id = request.getParameter("id");
System.out.print("upload"+id);
 InputStream inputStream = null;
Part videoPart = request.getPart("videoFile");
if (videoPart != null && videoPart.getSize() > 0) {
    inputStream = videoPart.getInputStream();
}

Connection connection = null;
PreparedStatement statement = null;

try {
    // connect to database
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade", "root", "noor123");

    String sql = "INSERT INTO videos (title, description, video) values (?, ?, ?)";
    statement = connection.prepareStatement(sql);
    statement.setString(1, title);
    statement.setString(2, description);
    if (inputStream != null) {
        statement.setBlob(3, inputStream);
    }
    statement.executeUpdate();

    request.setAttribute("message", "Video uploaded successfully!");
    request.getRequestDispatcher("/view.jsp").forward(request, response);
} catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
 } finally {
    if (statement != null) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (inputStream != null) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
 
 
 
 
 %>
 <body>  
 <  
          
</body>
</html>