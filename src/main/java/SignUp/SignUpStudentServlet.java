package SignUp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Student;
import login.*;

/**
 * Servlet implementation class SignUpStudentServlet
 */
@WebServlet("/SignUp")
public class SignUpStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 RequestDispatcher rd=request.getRequestDispatcher("sd.jsp");  
		   
         rd.forward(request, response);	
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
	
		String studentType = request.getParameter("category");
		String userType = "Student";
        request.setAttribute("username", username);


			Student s = new  Student();
			s.setFirstName(firstName);
			s.setUsername(username);
			s.setEmailID(email);
			s.setLastName(lastName);
			s.setPassword(password);
		s.setStudentType(studentType);
			System.out.print(s.getUsername());
			 
		//	HttpSession session = request.getSession( );	
			request.setAttribute("s", s);
 			 String password1=password.toUpperCase();
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
 							    

	
							    
				    if( digit!=password.length() ) {
	 				    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number ");
                          RequestDispatcher rd=request.getRequestDispatcher("SignUpStudent.jsp");  
					   
		               rd.forward(request, response);	

					 
				 }	      
				 if(password.length()<6){
 					    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number");
					    RequestDispatcher rd=request.getRequestDispatcher("SignUpStudent.jsp");  
					   					   
					   		               rd.forward(request, response);	
	 
			     }
				 
			 try {
				if(Studentdb.searchUsername(username)==true){
						    request.setAttribute("errorMessage", "Username already exists : username must be unique");

					 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
					if(Studentdb.verifyEmail(email,username)==true){
							    request.setAttribute("errorMessage", "Invalid  ");

						 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
				 String substring="@gmail.com";

				 boolean emailContains= email.contains("@gmail.com");
	 			  
				 if(emailContains==false){
					    request.setAttribute("errorMessage", "Invalid email ");

				 }
				 else {
		 try {
			if(Studentdb.addStudent(s)){
					//response.sendRedirect("Welcome.jsp");
					 RequestDispatcher rd=request.getRequestDispatcher("MyProfile.jsp");  
					   
		               rd.forward(request, response);		
			}
				 else{
						//response.sendRedirect("Error.jsp");
					    request.setAttribute("errorMessage", "Could not register Please try again later");

						 RequestDispatcher rd=request.getRequestDispatcher("SignUpStudent.jsp");  
						   
			               rd.forward(request, response);	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			 }}
	
	}


