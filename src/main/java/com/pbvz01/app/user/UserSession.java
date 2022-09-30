package com.pbvz01.app.user;

import com.pbvz01.app.database.DBUser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSession
{
		private static User activeUser;

		private UserSession(){}

		public static void setActiveUser(User user)
		{
				activeUser = user;
				if(activeUser.getName() == null)
						fullCompletion(activeUser);
		}
		public static User getActiveUser()
		{
				return activeUser;
		}
		private static void fullCompletion(User user)
		{
				ResultSet resultSet = DBUser.getUser(user);
				try
				{
						while(resultSet.next())
						{
								user.setName(resultSet.getString(4));
								user.setTeacher(resultSet.getBoolean(5));
						}
				}
				catch (SQLException e)
				{
						e.printStackTrace();
				}
		}
}
