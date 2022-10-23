package com.pbvz01.app.user;

import com.pbvz01.app.database.DBUser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSession {
		private static UserSession instance;
		private static User user;
		private UserSession(User user){
			this.user = user;
		}

		public static UserSession setInstance(User user) {
			if (instance == null) {
				if (user.getName() == null) {
					fullCompletion(user);
				}
				instance = new UserSession(user);
			}
			return instance;
		}

		public static User getInstance() {
			return user;
		}

		private static void fullCompletion(User user) {
				ResultSet resultSet = DBUser.getUser(user);
				try {
						while(resultSet.next()) {
								user.setName(resultSet.getString(4));
								user.setTeacher(resultSet.getBoolean(5));
						}
				}
				catch (SQLException e) {
						e.printStackTrace();
				}
		}
}
