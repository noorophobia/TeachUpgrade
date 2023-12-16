package login;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
public class Teacher implements User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String firstName, lastName, emailID,  UserType,username,password;
	 
	public Teacher() {
		this.username = " ";
		this.password = " ";
 			this.firstName = " ";
			this.lastName = "  ";
			this.emailID = "  ";
			this.UserType =  " ";	
	}
	public Teacher(String username,String password,String firstName,String lastName,String emailID,String UserType){
 
		this.username = username;
		this.password = password;
 			this.firstName = firstName;
			this.lastName = lastName;
			this.emailID = emailID;
			this.UserType = UserType;	
	}
	void SignUp(String username,String password,String firstName,String lastName,String emailID,String UserType)
	{
		this.username = username;
		this.password = password;
 			this.firstName = firstName;
			this.lastName = lastName;
			this.emailID = emailID;
			this.UserType = UserType;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public void setUserType(String UserType) {
		this.UserType = UserType;
	}
	public String getUsername() {
		return username;}
	
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public String getUserType() {
		return UserType;
	}
	  
	public String getfirstName() {
	    return firstName;
	}

	public String getlastName() {
	    return lastName;
	}

	public String getemailID() {
	    return emailID;
	}
	  public Teacher searchUser() {
		  return this;
	  }
	 
 public boolean deleteAccount() throws Exception {
	 if(Teacherdb.deletAccount(this)) {
		 return true;
	 }
	return false;
	   
	 
 }
public	boolean forgotPassword(String email,String uname,String pass) throws Exception {
		
		boolean b = Teacherdb.verifyEmail(email,uname);
		if(b==true) {
			Teacherdb.updatePassword(uname,pass);
		}
		return b;
		}
@Override
public boolean login(String username, String password) throws Exception {
	setUsername(username);
	setPassword(password);
	boolean b = Teacherdb.verifyUser(this);
	return b;
	}
}


