package com.pbvz01.app.controller;


import java.sql.ResultSet;

import com.pbvz01.app.constants.ControllerConst;
import com.pbvz01.app.database.DBUser;
import com.pbvz01.app.form_manager.FormManager;
import com.pbvz01.app.user.User;
import com.pbvz01.app.user.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AuthorizationСontroller {
    private User user;
    @FXML
    private Button createAccountBtn;
    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Text messageText;
    @FXML
    private Button signUpBtn;

    @FXML
    void initialize()
    {
        signUpBtn.setOnAction(event ->
            {
                String login = login_field.getText().trim();
                String password = password_field.getText().trim();

                if(!login.isEmpty() && !password.isEmpty())
                {
                    if(loginUser(login, password))
                    {
                        UserSession.setInstance(user);
                        FormManager.hideForm(signUpBtn.getScene());
                        FormManager.createNewForm(ControllerConst.MENU_FORM);
                    }
                    else
                    {
                        messageText.setText("Користувача не знайдено");
                    }
                }
                else
                {
                    messageText.setText("Введено не усі поля");
                }
            });

        createAccountBtn.setOnAction(event ->
            {
                FormManager.hideForm(createAccountBtn.getScene());
                FormManager.createNewForm(ControllerConst.REGISTRATION_FORM);
            });
    }
    private boolean loginUser(String login, String password)
    {
        if (checkDefaultData(login, password))
            return true;


        user = new User();
        user.setLogin(login);
        user.setPassword(password);
        ResultSet resultSet = DBUser.getUser(user);

        return DBUser.checkUser(resultSet);
    }
    private boolean checkDefaultData(String login, String password)
    {
        if(login.equals("admin") & password.equals("admin"))
        {
            user = new User("admin", "admin", "Учитель", true);
            return true;
        }
        else if(login.equals("student") & password.equals("student"))
        {
            user = new User("student", "student", "Ученик", false);
            return true;
        }
        return false;
    }
}
