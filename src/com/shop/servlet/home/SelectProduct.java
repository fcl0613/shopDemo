package com.shop.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.Category;
import com.shop.entity.Products;
import com.shop.service.CategoryDao;
import com.shop.service.ProductDao;

/**
 * Servlet implementation class SelectProduct
 */
@WebServlet("/fcl/selectproductlist")
public class SelectProduct extends HttpServlet {
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
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		int id = 0;
		ArrayList<Products> proList = null;
		if (fid != null) {
			id = Integer.parseInt(fid);
			proList = ProductDao.selectAllByCateId(id);
		}
		if (cid != null) {
			id = Integer.parseInt(cid);
			proList = ProductDao.selectAllByCateId(id);
		}
		
		request.setAttribute("title", CategoryDao.selectcateByid(id).getCatename());
		request.setAttribute("proList", proList);
		
		request.setAttribute("flist", flist);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/fcl/prolist.jsp").forward(request, response);
	}
}
