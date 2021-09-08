package com.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addFeedback  extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String username =req.getParameter("username");
	String email =req.getParameter("email");
	String feedback =req.getParameter("feedback");
	
	
	

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
    	
    	System.out.println(String.format("insert into E_FEEDBACKS values(feedbackId.nextval,'','%s','%s','%s')",username,email,feedback));
		ResultSet rs=stmt.executeQuery(String.format("insert into E_FEEDBACKS values(feedbackId.nextval,'','%s','%s','%s')",username,email,feedback));
		
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
    req.getRequestDispatcher("index.html").forward(req,res);
	
	}
}
