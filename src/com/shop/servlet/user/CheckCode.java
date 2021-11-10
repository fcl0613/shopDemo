package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCode
 */
@WebServlet("/fcl/checkcode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		HttpSession session = request.getSession();
		String syscode = (String)session.getAttribute("code");
		PrintWriter p = response.getWriter();
		if (syscode.equalsIgnoreCase(num)) {
			p.print("true");
		}else {
			p.print("false");
		}
		p.close();
	}

}
