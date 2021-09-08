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

public class addCourseDb extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String courseName = req.getParameter("courseName");
		String courseRef = req.getParameter("refrence");
		String courseDesc = req.getParameter("desc");
		String courseFees = req.getParameter("fees");
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
        	
        	System.out.println(String.format("insert into E_Courses values(courseId.nextval,'%s','%s','%s','%s',)",courseName,courseRef,courseDesc,courseFees));
			ResultSet rs=stmt.executeQuery(String.format("insert into E_Learn values(courseId.nextval,'%s','%s','%s','%s',)",courseName,courseRef,courseDesc,courseFees));
			
			if(rs.next()) {
				System.out.println("HAS NEXT courses");
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
