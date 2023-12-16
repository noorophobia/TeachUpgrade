package SignUp;

import javax.servlet.http.Cookie;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
 
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	        HttpSession session = request.getSession(true);

 		if (request.getParameter("student") != null){
			
			Cookie cookie=new Cookie("usert","student" );
			response.addCookie(cookie);
 
 			session.setAttribute("usert", "student");
 			 
 
 			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);	
 
			
		}
		else if (request.getParameter("teacher") != null){
   			Cookie cookie=new Cookie("usert","teacher" );
			response.addCookie(cookie);
 

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		 }
		else if (request.getParameter("admin") != null){
    			Cookie cookie=new Cookie("usert","admin" );
			response.addCookie(cookie);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("student") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpStudent.jsp");
			dispatcher.forward(request, response);		 }
		else if (request.getParameter("teacher") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpteacher.jsp");
			dispatcher.forward(request, response);
		 }
		 
	}
 }
	

