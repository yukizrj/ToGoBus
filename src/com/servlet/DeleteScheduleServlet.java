package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RouteDao;
import com.dao.ScheduleDao;

@WebServlet("/DeleteScheduleServlet")
public class DeleteScheduleServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("schedule_id");
		int schedule_id=Integer.parseInt(id);
		int rowd=ScheduleDao.deleteschedule(schedule_id);
		RequestDispatcher rd=request.getRequestDispatcher("AdminIndex.jsp");
		rd.forward(request, response);
	}

}
