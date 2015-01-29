/**
 * @包名称 com.coky.user.dao
 * @文件名 AdminDao.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:50:13
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:50:13
 * @修改描述 
 */

package com.coky.user.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coky.user.pojo.Admin;
import com.coky.user.util.IdGenerator;
import com.coky.user.util.SecurityEncode;

/** 
 * 功能描述 
 * @类型名称 AdminDao
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:50:13
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:50:13
 * @修改描述 
 */
public class AdminDao {

	public boolean checkLogin(String username, String pwd) {
		PreparedStatement st = null;
		Connection conn = null;
		try {
			String md5pwd = SecurityEncode.encoderByMd5(pwd);
			conn = DaoFactory.getConnection();
			st = conn.prepareStatement("select id, name, pwd from User where name=? and pwd=?");
			st.setString(1, username);
			st.setString(2, md5pwd);
			
			boolean execute = st.execute();
			if(execute){
				ResultSet rs = st.getResultSet();
				if(rs.next()){
					rs.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		
		return false;
	}

	public List<Admin> getAdminList() {
		List<Admin> result = new ArrayList<Admin>();
		Connection conn = DaoFactory.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			boolean execute = st.execute("select id, name, pwd from User");
			if(execute){
				ResultSet rs = st.getResultSet();
				while(rs.next()){
					Admin a = new Admin();
					a.setId(rs.getString(1));
					a.setName(rs.getString(2));
					a.setPwd(rs.getString(3));
					result.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		
		return result;
		
	}

	public boolean deleteById(String id) {
		Connection conn = DaoFactory.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from User where id=?");
			st.setString(1, id);
			st.execute();
			return st.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		return false;
	}

	public boolean addAdmin(String name, String pwd) {
		Connection conn = DaoFactory.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into User values(?,?,?)");
			st.setString(1, IdGenerator.randomId());
			st.setString(2, name);
			st.setString(3, SecurityEncode.encoderByMd5(pwd));
			st.execute();
			return st.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		return false;
	}

	public Admin getUserById(String id){
		Connection conn = DaoFactory.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("select id, name, pwd from User where id=?");
			st.setString(1, id);
			boolean execute = st.execute();
			if(execute){
				ResultSet rs = st.getResultSet();
				while(rs.next()){
					Admin a = new Admin();
					a.setId(rs.getString(1));
					a.setName(rs.getString(2));
					a.setPwd(rs.getString(3));
					return a;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		
		return null;
	}

	public boolean updatePassword(String id, String pwd) {
		Connection conn = DaoFactory.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update User set pwd=? where id=?");
			st.setString(1, pwd);
			st.setString(2, id);
			st.execute();
			return st.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoFactory.close(conn, st);
		}
		return false;
	}
	
}
