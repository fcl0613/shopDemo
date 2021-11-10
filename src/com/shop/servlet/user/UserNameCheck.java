package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.UserDao;

/**
 * Servlet implementation class UserNameCheck
 */
@WebServlet("/fcl/usernamecheck")
public class UserNameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("name");
		int con = UserDao.selectUser(username);
		PrintWriter p = response.getWriter();
		if (con>0) {
			p.print("false");
		}else {
			p.print("true");
		}
		p.close();
	}
}
