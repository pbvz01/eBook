package com.pbvz01.app.database;

import com.pbvz01.app.constants.DatabaseConst;
import com.pbvz01.app.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser
{
		private static final Connection connection = DBConnection.getDBConnection();

		private DBUser() {}

		// Adding new user to database
		public static void signUpUser(User user) throws SQLException
		{
						PreparedStatement statement = connection.prepareStatement(DatabaseConst.INSERT_NEW_USER);
						statement.setString(1, user.getLogin());
						statement.setString(2, user.getPassword());
						statement.setString(3, user.getName());
						statement.setBoolean(4, user.isTeacher());

						statement.executeUpdate();
						connection.close();
		}
		// Getting user from the database for creating the object class user
		public static ResultSet getUser(User user)
		{
				ResultSet resultSet = null;
				try
				{
						PreparedStatement statement = connection.prepareStatement(DatabaseConst.SELECT_USER);
						statement.setString(1, user.getLogin());
						statement.setString(2, user.getPassword());
						resultSet = statement.executeQuery();

				}
				catch (SQLException e)
				{
						e.printStackTrace();
				}
				return resultSet;
		}
		// Checking the user is in the database
		public static boolean checkUser(ResultSet resultSet)
		{
				int counter = 0;
				try
				{
						while(resultSet.next())
								counter++;

						return counter > 0 ? true : false;
				}
				catch (SQLException e)
				{
						//e.printStackTrace();
						System.out.println("Тут ошибка");
				}
				return false;
		}
}
