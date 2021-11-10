package com.shop.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Adminlogin
 */
@WebFilter("/manage/*")
public class Adminlogin implements Filter {

    /**
     * Default constructor. 
     */
    public Adminlogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		String flag = (String)session.getAttribute("isAdminLogin");
		//System.out.println(flag);
		String reqURI = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String uri = reqURI.substring(ctxPath.length());
		if (uri.contains("adminlogin")) {
			chain.doFilter(req, resp);
		}else {
			if (flag != null && flag.equals("1")) {
				chain.doFilter(req, resp);
			}else {
				PrintWriter out = resp.getWriter();
				out.write("<script>");
				out.write("alert('请先登录');");
				out.write("location.href='adminlogin.jsp';");
				out.write("</script>");
				out.close();
			}
		}
		//chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
