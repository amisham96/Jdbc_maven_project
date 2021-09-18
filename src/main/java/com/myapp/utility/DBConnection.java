package com.myapp.utility;

import java.sql.Connection;

import com.myapp.exception.daoexception.DaoException;

public interface DBConnection {

	Connection getConnection() throws DaoException;

	String closeConnection() throws DaoException;

}
