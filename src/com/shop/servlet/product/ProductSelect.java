package com.shop.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.Products;
import com.shop.service.ProductDao;

/**
 * Servlet implementation class ProductSelect
 */
@WebServlet("/manage/adminselectproduct")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1;
		int count = 5;
		String cp = request.getParameter("cp");
		String keywords = request.getParameter("keywords");
		if (cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = ProductDao.totalPage(count, keywords);
		ArrayList<Products> plist = ProductDao.selectAll(keywords,count,cpage);
		request.setAttribute("plist", plist);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		request.getRequestDispatcher("adminproduct.jsp").forward(request, response);
	}

}
