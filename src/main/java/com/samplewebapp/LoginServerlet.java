package com.samplewebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginServerlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setAttribute("warningDisp", "none");
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (UserValidationService.validateUser(username, password)) {		
			req.setAttribute("name", username);
			req.getRequestDispatcher("views/home.jsp").forward(req, resp);
		} else {
			req.setAttribute("warningDisp", "block");
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
		}
	}

}
