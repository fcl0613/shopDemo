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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admindouserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int userid = Integer.valueOf(request.getParameter("userid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int sex = Integer.valueOf(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		int cpage = Integer.valueOf(request.getParameter("cpage"));
		String keyword = request.getParameter("keyword");
		
		PrintWriter out = response.getWriter();
		User u = new User(userid, username, password, sex, phone, address);
		int res = UserDao.updateUser(u);
			
		if (res > 0) {
			out.write("<script>");
			out.write("alert('用户修改成功');");
			out.write("location.href='admindouserselect?cp="+cpage+"&keywords="+keyword+"';");
			out.write("</script>");
//			response.sendRedirect("adminuseradd.jsp");
		}else {
			out.write("<script>");
			out.write("alert('用户修改失败');");
			out.write("location.href='admintouserupdate';");
			out.write("</script>");
		}
		out.close();
	}

}
