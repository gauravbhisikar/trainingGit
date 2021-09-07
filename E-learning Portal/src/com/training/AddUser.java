package com.training;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		String address =req.getParameter("address");
		String email =req.getParameter("email");
		String phonenumber =req.getParameter("number");
		System.out.println(username);
		System.out.println(password);
		System.out.println(address);
		System.out.println(email);
		System.out.println(phonenumber);
	}
}
