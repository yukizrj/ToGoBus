package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.dao.AdminDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String page="index.jsp";
		String msg="Invalid username or password";
		Admin admin=new Admin(username,password);
		boolean exist=AdminDao.isValidate(admin);
		if(exist){
			page="AdminIndex.jsp";
			msg="Login successed";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
