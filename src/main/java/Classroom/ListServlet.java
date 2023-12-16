package Classroom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import login.*;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logindb dao = new logindb();
 
        try {
 
            List<category> listCatagory = dao.list();
            request.setAttribute("listCategory", listCatagory);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("MyProfile.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}