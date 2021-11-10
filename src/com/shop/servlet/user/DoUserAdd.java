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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admindouseradd")
public class DoUserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int sex = Integer.valueOf(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		int a = UserDao.selectUser(username);
		PrintWriter out = response.getWriter();
		//System.out.println(a);
		if (a>0) {
			out.write("<script>");
			out.write("alert('该用户名已存在');");
			out.write("location.href='adminuseradd.jsp';");
			out.write("</script>");
			//response.sendRedirect("adminuseradd.jsp");
		}else {
			User u = new User(username, password, sex, phone, address);
			int res = UserDao.insertUser(u);
			
			if (res > 0) {
				out.write("<script>");
				out.write("alert('用户添加成功');");
				out.write("location.href='adminuseradd.jsp';");
				out.write("</script>");
//				response.sendRedirect("adminuseradd.jsp");
			}else {
				out.write("<script>");
				out.write("alert('用户添加失败');");
				out.write("location.href='adminuseradd.jsp';");
				out.write("</script>");
			}
		}
		out.close();
	}

}
