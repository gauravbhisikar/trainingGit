package com.training;
import java.sql.*;  

public class userRegister {
	  
	public static void main(String args[]){  
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:8081:xe","sys","orcl");  
	  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
	  
	//step4 execute query  
	ResultSet rs=stmt.executeQuery("select * from E_USERS");  
	  
	  
	//step5 close the connection object  
	stmt.getConnection().close();  
	}catch(Exception e){ System.out.println(e);}  
	  
	
	}  
}
	
