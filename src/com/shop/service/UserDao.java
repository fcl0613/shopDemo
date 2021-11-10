package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.BaseDao;
import com.shop.entity.User;

public class UserDao {
	/**
	 * 增加用户
	 * @param u
	 * @return
	 */
	public static int insertUser(User u) {
		int res = 0;
		String sql = "INSERT INTO user VALUES(null,?,?,?,?,?)";
		Object[] params = {
				u.getUsername(),
				u.getPassword(),
				u.getUsersex(),
				u.getPhone(),
				u.getAddress()
		};
		res = BaseDao.exectuIUD(sql, params);
		return res;
	}
	
	
	
	public static int selectUser(String userName) {
		int res = 0;
		String sql = "SELECT * FROM user WHERE username=?";
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	public static ArrayList<User> selectAll(String keyWord, int count, int page){
		ArrayList<User> list = new ArrayList<User>();
		String sql = "";
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getconn();
		try {
			if (keyWord != null && !keyWord.equals("")) {
				sql = "SELECT * FROM user WHERE username LIKE ? ORDER BY userid ASC LIMIT ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyWord+"%");
				ps.setInt(2, (page -1)*count);
				ps.setInt(3, count);
			}else {
				sql = "SELECT * FROM user ORDER BY userid ASC LIMIT ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (page -1)*count);
				ps.setInt(2, count);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(
						rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("usersex"),
						rs.getString("phone"),
						rs.getString("address")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, rs, ps);
		}
		return list;
	}
	
	
	/**
	 * 获取总记录数和总页数
	 * arr[0]  总记录数
	 * arr[1]  总页数
	 * @param count
	 * @return
	 */
	public static int[] totalPage(int count, String keyWords) {
		int arr[] = {0,1};
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if (keyWords != null && !keyWords.equals("")) {
				sql = "SELECT COUNT(*) FROM user WHERE username LIKE ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyWords+"%");
			}else {
				sql = "SELECT COUNT(*) FROM user";
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
	
	
	
	public static User selectUserById(String id) {
		User u = null;
		String sql = "SELECT * FROM user WHERE userid=?";
		Connection conn = BaseDao.getconn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(
						rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("usersex"),
						rs.getString("phone"),
						rs.getString("address")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	
	public static int updateUser(User u) {
		int res = 0;
		String sql = "UPDATE user SET password=?,usersex=?,phone=?,address=? WHERE userid=?";
		Object[] params = {
				u.getPassword(),
				u.getUsersex(),
				u.getPhone(),
				u.getAddress(),
				u.getUserid()
		};
		res = BaseDao.exectuIUD(sql, params);
		return res;
	}
	
	
	public static int deleteUser(int id) {
		int res = 0;
		String sql = "DELETE FROM user WHERE userid=?";
		Object[] params = {id};
		res = BaseDao.exectuIUD(sql, params);
		return res;
	}
	
	
	public static int selectUserByNaPsd(String username, String password) {
		int res = 0;
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		Connection conn = BaseDao.getconn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("userid") != 0) {
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
	
}
