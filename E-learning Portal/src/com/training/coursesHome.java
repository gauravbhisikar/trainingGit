package com.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class coursesHome {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url= "jdbc:oracle:thin:@//localhost:1521/orcl";
        String userName = "sys as sysdba";
        String password1 = "system";
        Connection con = null;
		try {
			con = DriverManager.getConnection(url,userName,password1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	
        	
			ResultSet rs=stmt.executeQuery("select * from E_Courses");
			
			if(rs.next()) {
				System.out.println("HAS NEXT E_COurses");
			}
			else {
				System.out.println("No next Ecourses");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
}

	
	}
	

