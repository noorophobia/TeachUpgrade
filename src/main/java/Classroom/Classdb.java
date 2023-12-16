package Classroom;
import java.lang.Class;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  import java.util.*;
  import java.util.ArrayList;
  public class Classdb {

	final static 	String url="jdbc:mysql://localhost:3306/teachupgrade";//connection created
 	static boolean status=false; 
	    final static 	String uname="root";
     final static 	String pass="noor123";
     
     
 	public static boolean searchClass(String className)  
			throws Exception
	{
 		String sql1="select * from student where classname=? ";
        Class.forName("com.mysql.cj.jdbc.Driver");	 
        Connection con =DriverManager.getConnection(url,uname,pass);  
 		PreparedStatement st=con.prepareStatement(sql1);
 		st.setString(1, className);
  		ResultSet rs= st.executeQuery( );
 		status=rs.next();  

		 return status;
		

	}
 	
 
public List<ClassroomClass> list() throws SQLException {
     List<ClassroomClass> listCategory=new ArrayList<ClassroomClass>();

     Connection con =DriverManager.getConnection(url,uname,pass);  
        String sql = "SELECT * FROM class";
        Connection conm =DriverManager.getConnection(url,uname,pass);  
 		PreparedStatement st=conm.prepareStatement(sql);
   		ResultSet rs= st.executeQuery( );
         
        while (rs.next()) {
            int id = rs.getInt("classid");
            String name = rs.getString("classname");
            ClassroomClass category = new ClassroomClass(id,name);
           
                 
            listCategory.add(category);
        }          
        
     
    return listCategory;
}
 	/*public List<String> list() throws SQLException {
 	     List<String> listCategory=new ArrayList<String>();

 	     Connection con =DriverManager.getConnection(url,uname,pass);  
 	        String sql = "SELECT  classname FROM class";
 	        Connection conm =DriverManager.getConnection(url,uname,pass);  
 	 		PreparedStatement st=conm.prepareStatement(sql);
 	   		ResultSet rs= st.executeQuery( );
 
 	        while (rs.next()) {
  	            String name = rs.getString("classname");
 	            listCategory.add(name);
 	        }          
 	        
 	     
 	    return listCategory;
 	}
 
*/
 
}

