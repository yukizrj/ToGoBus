package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Booking;
import com.dao.BookingDao;

@WebServlet("/BookTicketServlet")
public class BookTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		String scheduleid=request.getParameter("schedule_id");
		HttpSession session=request.getSession();
		String passanger=(String) session.getAttribute("passanger");
		int passnum=Integer.parseInt(passanger);
		System.out.println("session is"+passanger);
		int schedule_id=Integer.parseInt(scheduleid);
		Booking book=new Booking(schedule_id,name,email,passnum,phone);
		Booking book2=BookingDao.fullinfo(book);
		BookingDao.insert(book2);
		ResultSet rs=BookingDao.showbooking(book2);
		try {
			while(rs.next()){
				int id=rs.getInt("schedule_id");
				String departure=rs.getString("departure_time");
				int seats=BookingDao.getSeat(id, departure);
				int left=seats-passnum;
				BookingDao.setSeat(left,id,departure);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session.invalidate();
		ResultSet rs2=BookingDao.showbooking(book2);
		request.setAttribute("result", rs2);
		RequestDispatcher rd=request.getRequestDispatcher("print.jsp");
		rd.forward(request, response);
	}

}
