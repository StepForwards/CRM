package com.forward.tools;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	public static DataSource db = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return db;
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = db.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
