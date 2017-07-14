package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ScheduleDao;


@WebServlet("/SearchBusServlet")
public class SearchBusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String passanger=request.getParameter("passanger");
		int passnum=Integer.parseInt(passanger);
		
		ResultSet rs=ScheduleDao.ShowResult(date,from,to,passnum);
		HttpSession session=request.getSession();
		session.setAttribute("passanger",passanger);
		try {
			if(!rs.next()){
				RequestDispatcher rd=request.getRequestDispatcher("noresult.jsp");
				rd.forward(request, response);
			}
			else{
				ResultSet rs2=ScheduleDao.ShowResult(date,from,to,passnum);
				request.setAttribute("resultset", rs2);
				
				RequestDispatcher rd=request.getRequestDispatcher("BusResult.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
