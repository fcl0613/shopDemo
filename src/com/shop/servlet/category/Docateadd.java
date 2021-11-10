package com.shop.servlet.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.Category;
import com.shop.service.CategoryDao;

/**
 * Servlet implementation class Docateadd
 */
@WebServlet("/manage/admindocateadd")
public class Docateadd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String catename = request.getParameter("catename");
		int parentid = Integer.parseInt(request.getParameter("parentid"));
		Category c = new Category(0, catename, parentid);
		CategoryDao.cateadd(c);
		response.sendRedirect("adminselectcategory");
	}

}
