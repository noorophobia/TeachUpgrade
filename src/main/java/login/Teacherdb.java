package login;

 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Classroom.category;

 
public class Teacherdb   {
	
	final static 	String url="jdbc:mysql://localhost:3306/teachupgrade";//connection created
 	static boolean status=false; 
	    final static 	String uname="root";
     final static 	String pass="noor123";
 	public static boolean verifyUser(Teacher A)  
			throws Exception
	{
 		
 		  String sql="select * from Teacher where username=? and passwords=? " ;

        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql);
 		st.setString(1, A.getUsername());
 		st.setString(2, A.getPassword());
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
 	
 	public static int AddAnnouncemenT( String title,String description,String classID)  
			throws Exception
	{
 		
 		  String sql="Insert into announcement (title,description,classid) values(?,?,?)" ;

        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql);
 		st.setString(1, title);
 		st.setString(2, description);
 		st.setString(3, classID);
  		ResultSet rs= st.executeQuery( );
		    sql=" select  announcementid from announcement order by announcementid desc limit 1;" ;

  		st=con.prepareStatement(sql);
  		rs= st.executeQuery( );
  	    return 	rs.getInt("announcementid");
  		 
		
	} 
	public static boolean deletAccount(Teacher A)  
			throws Exception
	{
 		
 		  String sql="delete  from Teacher where username=? and passwords=? " ;

        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql);
 		st.setString(1, A.getUsername());
 		st.setString(2, A.getPassword());
  		ResultSet rs= st.executeQuery( );
  		if(verifyUser(A)==false) {

		 return true;}
  		return false;
		
	}
 	
 	public static Teacher getTeacher(String username) 	throws Exception
	{
 		String sql1="select * from Teacher where username=? ";
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
 		String userType = rs.getString("userType");
 		Teacher s= new Teacher(  username,  password,  firstName,  lastName,  email, userType);
           s.setEmailID(email);
           s.setFirstName(firstName);
 		
 		return s;
 		

 		
	}
 
	public static boolean searchUsername(String username)  
			throws Exception
	{
 		String sql1="select username from Teacher where username=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, username);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	} 
	 
	public static boolean updatePassword(String username1,String password1)  
			throws Exception
	{
		
 		String sql1="update  Teacher set passwords=? where username =? ";
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
 		String sql1="select username from Teacher where emailid=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, email);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		
	}
    public static boolean addTeacher(Student a) 			throws Exception
 {
    	 
      	String sql1 ="insert into Teacher ( firstName,lastName,emailID,Username,Passwords, UserType )values(?,?,?,?,?,?)";
      	String username = a.getUsername();
		String password = a.getPassword();
		String firstName = a.getfirstName();
		String lastName = a.getlastName();
		String email = a.getemailID();
 		String userType = "Teacher";
        Class.forName("com.mysql.cj.jdbc.Driver");	//to load driver
        Connection con =DriverManager.getConnection(url,uname,pass); //Connection is an interface so we need class that implments it
 		PreparedStatement st=con.prepareStatement(sql1);
 		
 		st.setString(1, firstName);
 		st.setString(2, lastName);
 		st.setString(3, email);
 		st.setString(4, username);
 		st.setString(5, password);
 		
  		st.setString(6, userType);
 		
  		 
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
    	String sql1="update  Teacher set firstname=? where username =? ";
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
    	String sql1="update  Teacher set LastName=? where username =? ";
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
    	String sql1="update  Teacher set emailid=? where username =? ";
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
    	String sql1="update  Teacher set username=? where username =? ";
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
 
	
	 
	

