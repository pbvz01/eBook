package com.pbvz01.app.constants;

public class DatabaseConst
{
		public static final String DB_USER = "pbvz";
		public static final String DB_PASSWORD = "root";
		public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

		public static final String INSERT_NEW_USER = "INSERT INTO users_ebook " +
				"(login, password, name, check_teacher) VALUES(?,?,?,?)";

		public static final String SELECT_USER = "SELECT * FROM users_ebook WHERE login =? AND password =?";
}
