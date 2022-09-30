package com.pbvz01.app.user;

public class User
{
		private String login;
		private String password;
		private String name;
		private boolean isTeacher;

		public User(){}
		public User(String login, String password, String name, boolean isTeacher)
		{
				this.login = login;
				this.password = password;
				this.name = name;
				this.isTeacher = isTeacher;
		}

		public String getLogin()
		{
				return login;
		}

		public void setLogin(String login)
		{
				this.login = login;
		}

		public String getPassword()
		{
				return password;
		}

		public void setPassword(String password)
		{
				this.password = password;
		}

		public String getName()
		{
				return name;
		}

		public void setName(String name)
		{
				this.name = name;
		}

		public boolean isTeacher()
		{
				return isTeacher;
		}

		public void setTeacher(boolean teacher)
		{
				isTeacher = teacher;
		}
}
