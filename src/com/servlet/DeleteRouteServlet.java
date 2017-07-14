package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RouteDao;

@WebServlet("/DeleteRouteServlet")
public class DeleteRouteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String routeid=request.getParameter("route_id");
		int route_id=Integer.parseInt(routeid);
		int rowd=RouteDao.deleteroute(route_id);
		RouteDao.deleterouteschedule(route_id);  //delete schedule which belong to this route
		RequestDispatcher rd=request.getRequestDispatcher("AdminIndex.jsp");
		rd.forward(request, response);
	}

}
