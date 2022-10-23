package com.pbvz01.app.controller;

import java.sql.SQLException;

import com.pbvz01.app.constants.ControllerConst;
import com.pbvz01.app.database.DBUser;
import com.pbvz01.app.form_manager.FormManager;
import com.pbvz01.app.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterController
{
		@FXML
		private Button formRegisBtn;
		@FXML
		private Text messageLogin;
		@FXML
		private CheckBox regCheckBoxTeacher;
		@FXML
		private TextField regLogin_field;
		@FXML
		private TextField regName_field1;
		@FXML
		private PasswordField regPassword_field;

		@FXML
		void initialize() {
				formRegisBtn.setOnAction(event -> {
								boolean check = signUpNewUser();
								if(check) {
										FormManager.hideForm(formRegisBtn.getScene());
									   FormManager.createNewForm(ControllerConst.AUTHORIZATION_FORM);
								}
						});
		}

		private boolean signUpNewUser()
		{
				String login = regLogin_field.getText().trim();
				String password = regPassword_field.getText().trim();
				String name = regName_field1.getText().trim();
				boolean checker = regCheckBoxTeacher.isSelected();

				if(login.isEmpty() || password.isEmpty() || name.isEmpty())
				{
						messageLogin.setText("Введіть усі данні");
				}
				else
				{
						try
						{
								User user = new User(login, password, name, checker);
								DBUser.signUpUser(user);
								messageLogin.setText("Вас доданно до списку");
								return true;
						}
						catch (SQLException e)
						{
								messageLogin.setText("Користувач з таким логіном створен");
								regLogin_field.setText("");
								regName_field1.setText("");
								regPassword_field.setText("");
						}
				}
				return false;
		}
}
