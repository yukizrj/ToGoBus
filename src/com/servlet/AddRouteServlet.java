package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.Route;
import com.dao.RouteDao;



@WebServlet("/AddRouteServlet")
public class AddRouteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String routeid=request.getParameter("route_id");
		int route_id=Integer.parseInt(routeid);
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		Route route=new Route(route_id,source,destination);
		RouteDao.addnewroute(route);
		RequestDispatcher rd=request.getRequestDispatcher("AdminIndex.jsp");
		rd.forward(request, response);
	}

}
