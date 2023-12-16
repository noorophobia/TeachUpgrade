package Classroom;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayServlet")
@MultipartConfig

public class PlayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("his1");

        int id = Integer.parseInt(request.getParameter("id"));
        

        Connection connection1 = null;
        PreparedStatement statement1 = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        System.out.print("his1");

        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachupgrade", "root", "noor123");

            String sql = "SELECT * FROM videos ";
            PreparedStatement  statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

               resultSet = statement.executeQuery();
            if (resultSet.next()) {
                inputStream = resultSet.getBinaryStream("video");
            }
            connection1=connection;
            statement1=statement;
            response.setContentType("video/mp4");
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            if (inputStream != null) {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
 
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection1 != null) {
                try {
                    connection1.close();
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