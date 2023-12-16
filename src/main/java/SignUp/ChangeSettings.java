package SignUp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.*;
import login.Studentdb;
import login.Teacherdb;

/**
 * Servlet implementation class ChangeSettings
 */
@WebServlet("/ChangeSettings")
public class ChangeSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSettings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("usernames1");
		String usernameold = request.getParameter("usernames");
		//To retrieve the attribute from the session object
         if(username!=null && usernameold!=null) {
        	try {
				if( Studentdb.searchUsername(usernameold)==true) {
					Studentdb.updateusername(username, usernameold);
					 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
					   
		               rd.forward(request, response);	

				}
				else {
 				    request.setAttribute("errorMessage", "invlaid username  ");

					 RequestDispatcher rd=request.getRequestDispatcher("ChangeUsername.jsp");  
					   
		               rd.forward(request, response);	

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }


 		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("usernamer");
		String password =request.getParameter("oldpassword");
		String newpassword =  request.getParameter("newpassword");
		String new1password = request.getParameter("newpassword1");
		if(newpassword!=new1password) {
			request.setAttribute("errorMessage", "passwords do not match ");

			 RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
			   
              rd.forward(request, response);	

		}
		else if(newpassword!= null && new1password!= " "){
 				 String password1=newpassword;//.toUpperCase();
				 int digit = 0,chars=0; 
				    char element;

				    if (password1.length() >=6) {
				       
				    for(int i = 0; i < password1.length(); i++ ){

				        if(Character.isLetter(password1.charAt(i))) {
				        	chars++;
				        }
				        else if( Character.isDigit(password1.charAt(i) )){
	 			            digit++;
				        }}  }

					    digit=digit+chars;  
		


				    
	    if( digit!=newpassword.length() ) {
		    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number ");
             RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
		   
          rd.forward(request, response);	

		 
	 }	      
	 if(newpassword.length()<6){
			    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number");
		    RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
		   					   
		   		               rd.forward(request, response);	

    } 
	 try {
			if( Teacherdb.searchUsername(username)==  true) {
				Teacherdb.updatePassword( username, newpassword) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
			}
			if( Studentdb.searchUsername(username)==  true) {
				Studentdb.updatePassword( username, newpassword) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);

			}
			if( Admindb.searchUsername(username)==  true) {
				 Admindb.updatePassword( username, newpassword) ;
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);

			}
			
			else {
				  request.setAttribute("errorMessage", "Invalid credentials");
				    RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
				   					   
				   		               rd.forward(request, response);	
			}
			}
	 catch (Exception e) {
			e.printStackTrace();
			System.out.print("ew");
		}
	 }
			 
	}
	 
	 


}
