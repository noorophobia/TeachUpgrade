package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public interface User {
	 

	public boolean login(String username, String password) throws Exception;

	 
	  public User searchUser() throws Exception ;
	 
 public boolean deleteAccount() throws Exception ;
public 	boolean forgotPassword(String email,String uname,String pass) throws Exception;
 
 
}
 
	
  