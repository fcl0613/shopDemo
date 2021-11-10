package com.shop.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shop.entity.Products;
import com.shop.service.ProductDao;

/**
 * Servlet implementation class DoproAdd
 */
@WebServlet("/manage/admindoproadd")
public class DoproAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建SmartUploadd对象
		SmartUpload su = new SmartUpload();
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取上传的文件对象
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		String filename = f.getFileName();
		try {
			su.save("/images/product");
			f.saveAs("/images/product"+filename);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Request reql = su.getRequest();
		String proname = reql.getParameter("proname");
		int parentid = Integer.parseInt(reql.getParameter("parentid"));
		int childid = Integer.parseInt(reql.getParameter("childid"));
		String prodes = reql.getParameter("prodes");
		float proprice = Float.parseFloat(reql.getParameter("proprice"));
		int prostock = Integer.parseInt(reql.getParameter("prostock"));
		
		Products p = new Products(null, proname, prodes, proprice, prostock, parentid, childid, filename);
		int res = ProductDao.addproduct(p);
		if (res > 0) {
			response.sendRedirect("adminselectproduct");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('产品添加失败');");
			out.write("location.href='manage/admintoproductadd'");
			out.write("</script>");
		}
	}

}
