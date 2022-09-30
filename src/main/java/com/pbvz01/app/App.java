package com.pbvz01.app;

import com.pbvz01.app.constants.ControllerConst;
import com.pbvz01.app.form_manager.FormManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        FormManager.createNewForm(ControllerConst.AUTHORIZATION_FORM);
    }

    public static void main(String[] args)
    {
        launch();
    }

}