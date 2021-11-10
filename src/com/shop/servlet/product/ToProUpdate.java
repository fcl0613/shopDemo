package com.shop.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToProUpdate
 */
@WebServlet("/manage/adminetoproupdate")
public class ToProUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proname = request.getParameter("proname");
		String prodes = request.getParameter("prodes");
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keyword");
		request.setAttribute("proname", proname);
		request.setAttribute("prodes", prodes);
		request.setAttribute("cpage", cpage);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("adminuserupdate.jsp").forward(request, response);
	}

}
