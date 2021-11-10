package com.shop.servlet.product;

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
 * Servlet implementation class ToproAdd
 */
@WebServlet("/manage/admintoproductadd")
public class ToproAdd extends HttpServlet {
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
		request.setAttribute("fcate", flist);
		request.setAttribute("ccate", clist);
		request.getRequestDispatcher("adminproadd.jsp").forward(request, response);
	}
}
