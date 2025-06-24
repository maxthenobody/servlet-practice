package com.kh.menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menuOrder.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String main_menu = request.getParameter("main_menu");
		String side_menu = request.getParameter("side_menu");
		String drink_menu = request.getParameter("drink_menu");
		
		int price = 0;
		switch(main_menu) {
		case "한우버거": price += 5000; break;
		case "밥버거": price += 4500; break;
		case "치즈버거": price += 4000; break;
		}
		
		switch(side_menu) {
		case "감자튀김": price += 1500; break;
		case "어니언링": price += 1700; break;
		}
		
		switch(drink_menu) {
		case "콜라": case "사이다": price += 1000; break;
		case "커피": price += 1500; break;
		case "밀크쉐이크": price += 2500; break;
		}
		
		request.setAttribute("price", price);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response); // 데이터 그대로 담아서 전송
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
