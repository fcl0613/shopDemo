package com.shop.servlet.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.Category;
import com.shop.service.CategoryDao;

/**
 * Servlet implementation class TocateUpdate
 */
@WebServlet("/manage/admintocateupdate")
public class TocateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cateid = Integer.parseInt(request.getParameter("id"));
		Category c = CategoryDao.selectcateByid(cateid);
		ArrayList<Category> list = CategoryDao.selectAll();
		request.setAttribute("catelist", list);
		request.setAttribute("cate", c);
		request.getRequestDispatcher("admincateupdate.jsp").forward(request, response);
	}
}
