package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SettingServlet
 */
@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingServlet() {
         super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		  
			//response.sendRedirect("Settings.jsp");

  		// TODO Auto-generated method stub
		   if (request.getParameter("edi") != null) {
			//	  
 			request.getRequestDispatcher("Settings.jsp").forward(request, response);

 				//rd.include(request, response);

		  }
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		
		
		if( request.getParameter("changeusername")!=null){
			
			 RequestDispatcher rd=request.getRequestDispatcher("ChangeUsername.jsp");  
				   
	               rd.forward(request, response);	

		}
		if(request.getParameter("changepass")!=null) {
			 RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
			   
             rd.forward(request, response);	
		}
		
		
	/*	String username = request.getParameter("username1");
		String password =request.getParameter("oldpassword");
		String newpassword =  request.getParameter("newpassword");
		String new1password = request.getParameter("newpassword1");

		String firstName =  request.getParameter("firstname1");
		String lastName =  request.getParameter("lastname1");
		String email = request.getParameter("email1");

		String studentType =  request.getParameter("category1");
	      
		 
		if(username==null) {
			username= (String)request.getAttribute("username");
 
		}
	    
	    boolean changesMade=false;
	  		Student s = new  Student();
	  		s.setFirstName(firstName);
	  		s.setUsername(username);
	  		s.setEmailID(email);
	  		s.setLastName(lastName);
	  		s.setPassword(password);
	  	s.setStudentType(studentType);
	          String st=request.getParameter(username);
	         if(username!=null) {
	        	try {
					if( Studentdb.updateusername(username,st)) {
						changesMade=true;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	         
	         if(firstName!= null) {
	         	try {
					if( Studentdb.updateLastName(firstName,username)) {
						changesMade=true;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	         if(lastName!=null) {
	         	try {
					if( Studentdb.updateLastName(lastName,username)) {
						changesMade=true;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	         if(email!= null) {
	          	try {
					if( Studentdb.updateEmailID(email,username)) {
						changesMade=true;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           }
	         if(studentType!= null) {
	           	try {
					if( logindb.updateStudentType(studentType,username)) {
						changesMade=true;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }  
		                System.out.print(password);
	             if(password!= " " && password!=null) {
	            //	if( logindb.verifyUser(s)==false) {
	 				    request.setAttribute("errorMessage", "Invalid password ");

	            	}
	            	else {
	            		if(newpassword!= " " && new1password!= " ") {
	            			if(newpassword==new1password) {
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
	                          RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");  
	    				   
	    	               rd.forward(request, response);	

	    				 
	    			 }	      
	    			 if(newpassword.length()<6){
	    					    request.setAttribute("errorMessage", "Invalid password : Password must be 6 characters long with atleast 1 number");
	    				    RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");  
	    				   					   
	    				   		               rd.forward(request, response);	
	     
	    		     }
	    			 else {
	            				try {
									logindb.updatePasswordStudent(username, new1password);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	            				changesMade=true;}
	            			}
	            			else {
	         				    request.setAttribute("errorMessage", "Invalid password: Passwords don't match ");
	         				   RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");  
		   					   
		   		               rd.forward(request, response);	
	            			}
	            		}
	            	
	       
	           	 
	             
	            
	          else if(changesMade==true) {
	           request.setAttribute("success", "Changes made Successfully");
			 RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");  
				   
			             rd.forward(request, response);	
	           }}*/}
 			
	}

	