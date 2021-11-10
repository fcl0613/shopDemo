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
 * Servlet implementation class DoUserDelete
 */
@WebServlet("/manage/admindouserdelete")
public class DoUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keyword");
		int res = UserDao.deleteUser(id);
		PrintWriter out = response.getWriter();
//		if (res > 0) {
//			out.write("<script>");
//			out.write("alert('用户删除成功');");
//			out.write("location.href='admindouserselect?cp="+cpage+"&keywords="+keyword+"';");
//			out.write("</script>");
//		}else {
//			out.write("<script>");
//			out.write("alert('用户删除失败');");
//			out.write("location.href='admindouserselect?cp="+cpage+"&keywords="+keyword+"';");
//			out.write("</script>");
//		}
		out.write("<script>");
		if (res > 0) {
			out.write("alert('用户删除成功');");
		}else {
			out.write("alert('用户删除失败');");
		}
		out.write("location.href='admindouserselect?cp="+cpage+"&keywords="+keyword+"';");
		out.write("</script>");
		out.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String[] ids = request.getParameterValues("id[]");
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keyword");
		int flag = 1;
		PrintWriter out = response.getWriter();
		for (int i = 0; i < ids.length; i++) {
			flag = flag * UserDao.deleteUser(Integer.valueOf(ids[i]));
		}
		out.write("<script>");
		if (flag != 0) {
			out.write("alert('用户删除成功');");
		}else {
			out.write("alert('用户删除失败');");
		}
		out.write("location.href='admindouserselect?cp="+cpage+"&keywords="+keyword+"';");
		out.write("</script>");
		out.close();
	}

}
