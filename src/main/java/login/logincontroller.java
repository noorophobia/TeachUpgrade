package login;

import java.io.IOException;//
//<% import="javax.servlet.http.Cookie"%>
import javax.servlet.http.Cookie;

 import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

 

@WebServlet("/login1")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private logindb loginDao;

	public void init() {
		loginDao = new logindb();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			forgotPassword(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  if (request.getParameter("edi") != null) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("Settings.jsp");
				dispatcher.forward(request, response);
		  }
		  else
		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
 
	 
  	        HttpSession session1 = request.getSession(true);
 	       String usert=  (String)session1.getAttribute("usert");
 	       String user=  (String)session1.getAttribute("username");

 	      session1.setAttribute("username", username);
 
       if(usert=="student") {
		Student loginBean = new Student();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		loginBean.setUserType(usert);
        
       //  request.setAttribute("password", password);
       

		try {            request.setAttribute("username", username);
 
if (loginBean.login(username,password)==true) {
 				RequestDispatcher dispatcher = request.getRequestDispatcher("MyProfile.jsp");

				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
 				response.sendRedirect("Welcome.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.print("ew");
		}
      }
      else if(usert=="teacher") {
    		Teacher loginBean = new Teacher();
    		loginBean.setUsername(username);
    		loginBean.setPassword(password);
    		loginBean.setUserType(usert);
            
            request.setAttribute("username", username);
          //  request.setAttribute("password", password);
           

    		try {
    			if (loginBean.login(username,password)) {
     				RequestDispatcher dispatcher = request.getRequestDispatcher("MyProfile.jsp");

    				dispatcher.forward(request, response);
    			} else {
    				HttpSession session = request.getSession();
     				response.sendRedirect("Welcome.jsp");
    			}
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			System.out.print("ew");
    		}
      }
      else if(usert=="admin") {
    		Admin loginBean = new Admin();
    		loginBean.setUsername(username);
    		loginBean.setPassword(password);
    		loginBean.setUserType(usert);
            
            request.setAttribute("username", username);
          //  request.setAttribute("password", password);
           

    		try {
    			if (loginBean.login(username,password)) {
     				RequestDispatcher dispatcher = request.getRequestDispatcher("MyProfile.jsp");

    				dispatcher.forward(request, response);
    			} else {
    				HttpSession session = request.getSession();
     				response.sendRedirect("Welcome.jsp");
    			}
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			System.out.print("ew");
    		}
      }
	}
	
	private void forgotPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		System.out.print("ew1");

		 if(password!=password1) {
			  request.setAttribute("errorMessage", "Invalid password : Passwords do not match");
  			System.out.print("ew2");

              RequestDispatcher rd=request.getRequestDispatcher("forgotPassword.jsp");  
           rd.forward(request, response);	
		 }
		 else {
         
		 String password2=password.toUpperCase();
			 int digit = 0,chars=0; 
		    char element;

		    if (password2.length() >=6) {
		       
		    for(int i = 0; i < password2.length(); i++ ){

			        if(Character.isLetter(password2.charAt(i))) {
		        	chars++;
		        }
		        else if( Character.isDigit(password2.charAt(i) )){
			            digit++;
		        }}  }

			    digit=digit+chars;  
			    


		    
if( digit!=password2.length() ) {
	    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number ");
      RequestDispatcher rd=request.getRequestDispatcher("forgotPassword.jsp");  
   
   rd.forward(request, response);	

 
}	      
if(password2.length()<6){
	    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number");
    RequestDispatcher rd=request.getRequestDispatcher("forgotPassword.jsp");  
   					   
   		               rd.forward(request, response);	

}}
		 String substring="@gmail.com";

		 boolean emailContains= email.contains("@gmail.com");
			  
		 if(emailContains==false){
			    request.setAttribute("errorMessage", "Invalid email ");

		 }
		 else {

		try {
			if( Teacherdb.searchUsername(username)==  true) {
				Teacherdb.updatePassword( username, password1) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
			}
			if( Studentdb.searchUsername(username)==  true) {
				Studentdb.updatePassword( username, password1) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);

			}
			if( Admindb.searchUsername(username)==  true) {
				 Admindb.updatePassword( username, password1) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);

			}
			
			else {
				  request.setAttribute("errorMessage", "Invalid credentials");
				    RequestDispatcher rd=request.getRequestDispatcher("forgotPassword.jsp");  
				   					   
				   		               rd.forward(request, response);	
			}
			 
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.print("ew");
		}

	}
	}
}