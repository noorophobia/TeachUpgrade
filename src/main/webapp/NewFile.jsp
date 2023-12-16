 

<html>
     <%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
 <%@page import="java.io.InputStream"%>


 
<head>
<title>View Videos</title>
</head>
<body>
 <h2>View Videos</h2>
   
        
      <%
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");	
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade","root","noor123"); //Connection is an interface so we need class that implments it
    String sql3 = "SELECT video FROM videos   ";
  //to load driver
 
    byte[] buffer = new byte[4096];

    		PreparedStatement st=con.prepareStatement(sql3);
       	 

   		ResultSet rs= st.executeQuery(sql3);
               InputStream inputStream = null;
 
             // rs = st.executeQuery();
           if (rs.next()) {
               inputStream = rs.getBinaryStream("video");
           }
           
         	  %>
<video controls onplay="myFunction()">
        	  
  <source src=<%=rs.getBinaryStream("video")%> <% 
          response.setContentType("video/mp4");  %> type="video/mp4">
             	  
   <source src=<%=rs.getBinaryStream("video")%> <% 
          response.setContentType("video/ogg");  %> type="video/ogg">
          </video>
          
<%

  // byte[] buffer = new byte[4096];
            int bytesRead = -1;
            if (inputStream != null) {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
                
 
            }
  %>
          	  
        	 
        	  
        	  <%
          
          }
catch(Exception e){}
%>
 

 
<p id="demo"></p>

<script>
function myFunction() {
  document.getElementById("demo").innerHTML = "The video has started to play";
}
</script>
     </div>
</body>
</html>



</body>
</html>
