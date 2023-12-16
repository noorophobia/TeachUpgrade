<html>
     <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
 <%@page import="java.io.InputStream"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


 
<head>
<title>View Videos</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="HomePage.jsp">teachUpgrade</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

 <h2>View Videos</h2>
<c:forEach items="${videoList}" var="video">
<div>
<div>${video.title}</div>
<div>${video.description}</div>
<video width="640" height="360" controls>
<source src="/PlayServlet?id=" type="video/mp4">
<source src="/PlayServlet?id=" type="video/ogg">
</video>
</div>
</c:forEach>



 <div> 
        
      <%
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "SELECT * FROM videos where id=3 ";
  //to load driver
  
     
    		PreparedStatement st=con.prepareStatement(sql3);
   		ResultSet rs= st.executeQuery(sql3);
          while(rs.next()){
              InputStream inputStream = null;
 
             // rs = st.executeQuery();
           if (rs.next()) {
               inputStream = rs.getBinaryStream("video");
           }
        	  %>
        	  <video width="640" height="360" controls>
        	  
   <source src=<%=rs.getBinaryStream("video")%> <% 
          response.setContentType("video/mp4");

   byte[] buffer = new byte[4096];
            int bytesRead = -1;
            if (inputStream != null) {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
                
 
            }
  %>
  type="video/mp4">
         	  
        	 
        	  
        	  <%
          
          }}
catch(Exception e){}
%>




     </div>
</body>
</html>


