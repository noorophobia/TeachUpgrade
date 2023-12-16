package login;

 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Classroom.category;

 
public class logindb {
	
	final static 	String url="jdbc:mysql://localhost:3306/teachupgrade";//connection created
 	static boolean status=false; 
	    final static 	String uname="root";
     final static 	String pass="noor123";
 	public static boolean verifyUserS(Student A)  
			throws Exception
	{
 		
 		  String sql="select * from student where username=? and passwords=? " ;

        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql);
 		st.setString(1, A.getUsername());
 		st.setString(2, A.getPassword());
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
 	
 	public static boolean verifyUser(Teacher A)  
			throws Exception
	{
 		
 		  String sql="select * from teacher where username=? and passwords=? " ;

        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql);
 		st.setString(1, A.getUsername());
 		st.setString(2, A.getPassword());
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
 	public static boolean searchUsernameTeacher(String username)  
			throws Exception
	{
 		String sql1="select username from teacher where username=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, username);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	} 
 	public static Student getStudent(String username) 	throws Exception
	{
 		String sql1="select * from student where username=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, username);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next(); 
 		rs.getString("username");
         String password=rs.getString("passwords");
        String firstName=rs.getString("firstName");
 		String lastName = rs.getString("lastName");
		String email = rs.getString("emailid");
		String studentType = rs.getString("studentType");
		String userType = rs.getString("userType");
		Student s=new  Student(  username, password, firstName, lastName, email, studentType, userType);
           s.setEmailID(email);
           s.setFirstName(firstName);
 		
 		return s;
 		

 		
	}
 
	public static boolean searchUsernameStudent(String username)  
			throws Exception
	{
 		String sql1="select username from student where username=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, username);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	} 
	public static boolean updatePasswordTeacher(String username1,String password1)  
			throws Exception
	{
		
 		String sql1="update  teacher set passwords=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, password1);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
	public static boolean updatePasswordStudent(String username1,String password1)  
			throws Exception
	{
		
 		String sql1="update  student set passwords=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, password1);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
	public static boolean verifyEmail(String email,String username)  
			throws Exception
	{
 		String sql1="select username from student where emailid=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, email);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
    public static boolean addStudent(Student a) 			throws Exception
 {
    	 
      	String sql1 ="insert into Student ( firstName,lastName,emailID,Username,Passwords, StudentType, UserType )values(?,?,?,?,?,?,?)";
      	String username = a.getUsername();
		String password = a.getPassword();
		String firstName = a.getfirstName();
		String lastName = a.getlastName();
		String email = a.getemailID();
		String studentType = a.getStudentType();
		String userType = "Student";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		
 		st.setString(1, firstName);
 		st.setString(2, lastName);
 		st.setString(3, email);
 		st.setString(4, username);
 		st.setString(5, password);
 		
 		st.setString(6, studentType);
 		st.setString(7, userType);
 		
  		 
       int updateQuery = st.executeUpdate();
                      if (updateQuery != 0) {
                    	  return true;
                      }

		 return false;
    }
    public List<category> list() throws SQLException, ClassNotFoundException {
        List<category> listCategory = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");	
        String sql3 = "SELECT * FROM category ORDER BY name";
//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql3);
 		ResultSet rs= st.executeQuery( );

             
                         
            while (rs.next()) {
            	String id = rs.getString("id");
                String name = rs.getString("name");
                category category = new category(id, name);
                     
                listCategory.add(category);
            }          
             
         
        return listCategory;
    }
    public static boolean updateFirstName(String fname,String username1) throws ClassNotFoundException, SQLException {
    	String sql1="update  student set firstname=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, fname);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
 }
    
    public static boolean updateLastName(String fname,String username1) throws ClassNotFoundException, SQLException {
    	String sql1="update  student set LastName=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, fname);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
 }
    public static boolean updateEmailID(String fname,String username1) throws ClassNotFoundException, SQLException {
    	String sql1="update  student set emailid=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, fname);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
 }
    public static boolean updateStudentType(String fname,String username1) throws ClassNotFoundException, SQLException {
    	String sql1="update  student set StudentType=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, fname);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
 }
 
 
    public static boolean updateusername(String fname,String username1) throws ClassNotFoundException, SQLException {
    	String sql1="update  student set username=? where username =? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, fname);
 		st.setString(2, username1);
 		
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
 }
 


}
 
	
	 
	

