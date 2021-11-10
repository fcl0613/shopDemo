package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.User;
import com.shop.service.UserDao;

/**
 * Servlet implementation class Reginster
 */
@WebServlet("/fcl/reginster")
public class Reginster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User(username, password, 2, null, null);
		int res = UserDao.insertUser(u);
		PrintWriter out = response.getWriter();
		if (res>0) {
			response.sendRedirect("login.jsp");
			return;
		}else {
			out.write("<script>");
			out.write("alert('用户注册失败');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
