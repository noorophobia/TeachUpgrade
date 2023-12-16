package Classroom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Classdb dao = new Classdb();
	 
	        try {
	 
	            List<ClassroomClass> listCatagory = dao.list();
	            request.setAttribute("listCategory", listCatagory);
	 
	            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	            dispatcher.forward(request, response);
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ServletException(e);
	        }
	    }
	}

