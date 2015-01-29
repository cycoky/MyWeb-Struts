/**
 * @包名称 com.coky.user.dao
 * @文件名 DaoFactory.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:51:06
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:51:06
 * @修改描述 
 */

package com.coky.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * 功能描述 
 * @类型名称 DaoFactory
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:51:06
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:51:06
 * @修改描述 
 */
public class DaoFactory {

	private static final String username = "root";
	
	private static final String password = "root";
	
	private static final String url = "jdbc:mysql://localhost:3306/struts-learn?useUnicode=true&characterEncoding=utf-8";
	
	private static final String driveClassName = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			Class.forName(driveClassName);
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, Statement st) {
		try {
			if(conn != null){
				conn.close();
			}
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
