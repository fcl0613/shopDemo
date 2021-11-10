package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.dao.BaseDao;
import com.shop.entity.Admins;

public class AdminDao {
	public static int selectAdminByNaPsd(String username, String password) {
		int res = 0;
		String sql = "SELECT * FROM admin WHERE adminname=? AND password=?";
		Connection conn = BaseDao.getconn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("id") != 0) {
					res = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return res;
	}
	
	
	
	public static Admins selectAdminById(String id) {
		Admins a = null;
		String sql = "SELECT * FROM admin WHERE id=?";
		Connection conn = BaseDao.getconn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				a = new Admins(
						rs.getInt("id"),
						rs.getString("adminname"),
						rs.getString("password")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
