package Classroom;
/*
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
         Part videoPart = request.getPart("videoFile");
       // if (videoPart != null && videoPart.getSize() > 0) {
         InputStream  inputStream = videoPart.getInputStream();
      //  }
    	final   	String url="jdbc:mysql://localhost:3306/teachupgrade";//connection created
     	    final   	String uname="root";
         final   	String pass="noor123";
          Connection con1 =null;
          PreparedStatement statement = null;
 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver

            Connection con =DriverManager.getConnection(url,uname,pass); 
con1=con;
            String sql = "INSERT INTO videos (title, description, video) values (?, ?, ?)";
             //Connection is an interface so we need class that implments it
     		PreparedStatement statement1=con.prepareStatement(sql);
             statement1.setString(1, title);
            statement1.setString(2, description);
           // if (inputStream != null) {
                statement1.setBlob(3, inputStream);
           // }
            statement1.executeUpdate();
            statement=statement1;

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
            if (con1 != null) {
                try {
                    con1.close();
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
    }
}*/







import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        
        String id = (String) request.getParameter("selectclassid");
        String user = (String) request.getParameter("selectuser");
         
     	 
          
          
        String title = request.getParameter("title");
        String description = request.getParameter("description");
       
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
    }
}
