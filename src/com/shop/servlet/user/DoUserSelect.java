package com.shop.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.User;
import com.shop.service.UserDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admindouserselect")
public class DoUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1;
		int count = 10;
		
		//获取用户指定页面
		String cp = request.getParameter("cp");
		String keywords = request.getParameter("keywords");
		if (cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = UserDao.totalPage(count, keywords);
		ArrayList<User> list = UserDao.selectAll(keywords, count, cpage);
		//把结果放到请求域里面
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		//重定项
		if (keywords != null && !keywords.equals("")) {
			request.setAttribute("searchParams", "&keywords="+keywords);
		}
		request.getRequestDispatcher("adminuser.jsp").forward(request, response);
	}
}
