package com.shop.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.User;
import com.shop.service.UserDao;

/**
 * Servlet implementation class Douserupdate
 */
@WebServlet("/manage/admintouserupdate")
public class Touserupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keyword");
		
		User u = UserDao.selectUserById(id);
		request.setAttribute("user", u);
		request.setAttribute("cpage", cpage);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("adminuserupdate.jsp").forward(request, response);
	}

}
