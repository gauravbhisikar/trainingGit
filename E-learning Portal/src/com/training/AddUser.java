package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username_ =req.getParameter("username");
		String password_ =req.getParameter("password");
		String address =req.getParameter("address");
		String email =req.getParameter("email");
		String phonenumber =req.getParameter("number");
		
		System.out.println(username_);
		System.out.println(password_);
		System.out.println(address);
		System.out.println(email);
		System.out.println(phonenumber);
		
		
		
		
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
        	
        	System.out.println(String.format("insert into E_Learn values(userId.nextval,'%s','%s','%s','%s','%s','img.jpeg')",username_,address,phonenumber,email,password_));
			ResultSet rs=stmt.executeQuery(String.format("insert into E_Learn values(userId.nextval,'%s','%s','%s','%s','%s','img.jpeg')",username_,address,phonenumber,email,password_));
			
			if(rs.next()) {
				System.out.println("HAS NEXT");
			}
			else {
				System.out.println("No next");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.getRequestDispatcher("coursesHome.html").forward(req,res);
}

	
	
 
     }  
 






