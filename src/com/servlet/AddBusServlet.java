package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bus;
import com.bean.Schedule;
import com.dao.BusDao;
import com.dao.ScheduleDao;


@WebServlet("/AddBusServlet")
public class AddBusServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p=request.getParameter("plate");
		int plate=Integer.parseInt(p);
		String model=request.getParameter("model");
		String c=request.getParameter("capacity");
		int capacity=Integer.parseInt(c);
		String routeid=request.getParameter("route_id");
		int route_id=Integer.parseInt(routeid);
		String scheduleid=request.getParameter("schedule_id");
		int schedule_id=Integer.parseInt(scheduleid);
		String date=request.getParameter("date");
		String departure_time=request.getParameter("departure_time");
		String arrival_time=request.getParameter("arrival_time");
		String pr=request.getParameter("price");
		int price=Integer.parseInt(pr);
		Bus bus=new Bus(plate,model,capacity,route_id);
		Schedule schedule=new Schedule(schedule_id,plate,route_id,date,departure_time,arrival_time,capacity,price);
		BusDao.addnewbus(bus);
		ScheduleDao.addnewschedule(schedule);
		RequestDispatcher rd=request.getRequestDispatcher("AdminIndex.jsp");
		rd.forward(request, response);
		
	}

}
