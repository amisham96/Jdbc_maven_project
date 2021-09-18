package com.myapp.utility.utilityimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myapp.exception.daoexception.DaoException;
import com.myapp.utility.DBConnection;

public class DBConnectionImpl implements DBConnection {

	static Connection connection = null;

	@Override
	public Connection getConnection() throws DaoException {
		// TODO Auto-generated method stub
		String dburl = "jdbc:mysql://localhost:3306/roomdb";
		String dbusername = "root";
		String dbpassword = "Welcome@123";

		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(dburl, dbusername, dbpassword);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e.getMessage(), e);
			}
		}
		return connection;
	}

	@Override
	public String closeConnection() throws DaoException {
		// TODO Auto-generated method stub
		String result = "";

		try {
			if (connection != null & !connection.isClosed()) {
				connection.close();
				result = "Connection Closed Successfully..!  :)";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}
		return result;
	}

}
