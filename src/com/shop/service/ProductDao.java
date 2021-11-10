package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.BaseDao;
import com.shop.entity.Products;
import com.shop.entity.User;

public class ProductDao {
	public static int addproduct(Products p) {
		String sql = "INSERT INTO product VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				p.getProname(),
				p.getProdes(),
				p.getPropice(),
				p.getProstock(),
				p.getProfcateid(),
				p.getProccateid(),
				p.getPropicname()
		};
		return BaseDao.exectuIUD(sql, params);
	}
	
	
	
	public static ArrayList<Products> selectAll(){
		ArrayList<Products> list = new ArrayList<Products>();
		ResultSet rs = null;
		PreparedStatement ps= null;
		Connection conn = BaseDao.getconn();
		String sql = "SELECT * FROM product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Products p = new Products(rs.getInt("proid"),
						rs.getString("proname"), 
						rs.getString("prodes"),
						rs.getFloat("propice"),
						rs.getInt("prostock"),
						rs.getInt("profcateid"),
						rs.getInt("proccateid"),
						rs.getString("propicname"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return list;
	}
	
	
	public static ArrayList<Products> selectAll(String keyWord, int count, int page){
		ArrayList<Products> list = new ArrayList<Products>();
		String sql = "";
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getconn();
		try {
			if (keyWord != null && !keyWord.equals("")) {
				sql = "SELECT * FROM product WHERE proname LIKE ? ORDER BY proname ASC LIMIT ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyWord+"%");
				ps.setInt(2, (page -1)*count);
				ps.setInt(3, count);
			}else {
				sql = "SELECT * FROM product ORDER BY proid ASC LIMIT ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (page -1)*count);
				ps.setInt(2, count);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				Products p = new Products(rs.getInt("proid"),
						rs.getString("proname"), 
						rs.getString("prodes"),
						rs.getFloat("propice"),
						rs.getInt("prostock"),
						rs.getInt("profcateid"),
						rs.getInt("proccateid"),
						rs.getString("propicname"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return list;
	}
	
	
	
	public static ArrayList<Products> selectAllByCateId(int id){
		ArrayList<Products> list = new ArrayList<Products>();
		String sql = "";
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getconn();
		try {
			sql = "SELECT * FROM product WHERE profcateid=? OR proccateid=? ORDER BY proid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Products p = new Products(rs.getInt("proid"),
						rs.getString("proname"), 
						rs.getString("prodes"),
						rs.getFloat("propice"),
						rs.getInt("prostock"),
						rs.getInt("profcateid"),
						rs.getInt("proccateid"),
						rs.getString("propicname"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return list;
	}
	
	
	
	
	public static int[] totalPage(int count, String keyWords) {
		int arr[] = {0,1};
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if (keyWords != null && !keyWords.equals("")) {
				sql = "SELECT COUNT(*) FROM product WHERE proname LIKE ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyWords+"%");
			}else {
				sql = "SELECT COUNT(*) FROM product";
				ps = conn.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				arr[0] = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		if (arr[0] % count == 0) {
			arr[1] = arr[0]/count;
		}else{
			arr[1] = arr[0]/count + 1;
		}
		return arr;
	}
}
