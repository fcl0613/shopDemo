package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.BaseDao;
import com.shop.entity.Category;

public class CategoryDao {
	
	
	public static ArrayList<Category> selectAll(){
		ArrayList<Category> list = new ArrayList<Category>();
		Connection conn = BaseDao.getconn();
		ResultSet rs = null;
		PreparedStatement ps =null;
		String sql = "SELECT * FROM category ORDER BY parentid ASC";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category c = new Category(
						rs.getInt("cateid"), 
						rs.getString("catename"), 
						rs.getInt("parentid"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return list;
	}
	
	
	public static int cateadd(Category c) {
		int res = 0;
		String sql = "INSERT INTO category values(null , ?, ?)";
		Object[] params = {
				c.getCatename(),
				c.getParentid()
		};
		res = BaseDao.exectuIUD(sql, params);
 		return res;
	}
	
	
	public static Category selectcateByid(int id) {
		Category c = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getconn();
		String sql = "SELECT * FROM category WHERE cateid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c = new Category(rs.getInt("cateid"), rs.getString("catename"), rs.getInt("parentid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return c;
	}
	
	
	
	public static int cateupdate(Category c) {
		int res = 0;
		String sql = "UPDATE category SET catename=?, parentid=? WHERE cateid=?";
		Object[] params = {
				c.getCatename(),
				c.getParentid(),
				c.getCateid()
		};
		res = BaseDao.exectuIUD(sql, params);
		return res;
	}
	
	
	
	public static int catedel(int id) {
		int res = 0;
		String sql = "DELETE FROM category WHERE cateid=?";
		Object[] params = {id};
		res = BaseDao.exectuIUD(sql, params);
		return res;
	}
	
	
	
	
}
