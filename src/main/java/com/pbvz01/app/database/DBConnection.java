package com.pbvz01.app.database;

import com.pbvz01.app.constants.DatabaseConst;

import java.sql.*;


public class DBConnection
{
		private static Connection connection;

		public static Connection getDBConnection()
		{
				try
				{
						connection = DriverManager.getConnection(DatabaseConst.DB_URL, DatabaseConst.DB_USER,
								  DatabaseConst.DB_PASSWORD);
				}
				catch (SQLException e)
				{
						System.out.println("The connection with database failed");
						e.printStackTrace();
				}
				return connection;
		}

		private DBConnection() {}
}
