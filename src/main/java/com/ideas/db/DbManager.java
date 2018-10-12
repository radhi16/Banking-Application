package com.ideas.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	Connection connection = null;

	public ResultSet find(String query) {
		ConnectionManager connectionManager = new ConnectionManager();
		connection = connectionManager.getConnection();
		ResultSet resultset = null;
		try {
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;

	}

	public void save(String query) {
		ConnectionManager connectionManager = new ConnectionManager();
		connection = connectionManager.getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
