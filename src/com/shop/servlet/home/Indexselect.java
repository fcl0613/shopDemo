package com.shop.servlet.home;

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
 * Servlet implementation class Indexselect
 */
@WebServlet("/fcl/indexselect")
public class Indexselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> list = CategoryDao.selectAll();
		ArrayList<Category> flist = new ArrayList<Category>();
		ArrayList<Category> clist = new ArrayList<Category>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getParentid() == 0) {
				flist.add(list.get(i));
			}else {
				clist.add(list.get(i));
			}
		}
		request.setAttribute("flist", flist);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/fcl/index.jsp").forward(request, response);
	}
}
