package Classroom;

import java.io.IOException;
import java.sql.*;
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

/**
 * Servlet implementation class videoPlayerServlet
 */
@WebServlet("/videoPlayerServlet")
public class videoPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get video ID from request parameter
        int videoID = Integer.parseInt(request.getParameter("id"));
        
        // Get connection to database
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InputStream input = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
            
            // Get video data from database
            String sql = "SELECT video_data, video_mime_type FROM videos WHERE video_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, videoID);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Get video mime type
                String mimeType = rs.getString("video_mime_type");
                
                // Setup response
                response.setContentType(mimeType);
                response.setHeader("Content-Disposition", "inline");
                
                // Get video data as input stream
                input = rs.getBinaryStream("video_data");
                
                // Write video data to response output stream
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = input.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            } else {
                response.getWriter().write("Video not found.");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            if (input != null) {
                input.close();
            }
            
            if (rs != null) {
                try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
            if (stmt != null) {
                try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
            if (conn != null) {
                try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
}
