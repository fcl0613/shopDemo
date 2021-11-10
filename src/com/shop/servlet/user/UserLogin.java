package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.User;
import com.shop.service.UserDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/fcl/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int res = UserDao.selectUserByNaPsd(username, password);
		if (res > 0) {
			HttpSession session = request.getSession();
			User u = UserDao.selectUserById(String.valueOf(res));
			session.setAttribute("user", u);
			session.setAttribute("isLogin", "1");
			response.sendRedirect("/shop/fcl/indexselect");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户登录失败');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
