package com.pbvz01.app.form_manager;

import com.pbvz01.app.App;
import com.pbvz01.app.user.UserSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class FormManager
{
		public static void createNewForm(String fxml)
		{
				FXMLLoader loader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
				try
				{
						loader.load();
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}

				Parent root = loader.getRoot();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("The eBook for learning Web Design");
				stage.setResizable(false);
				stage.show();
		}
		public static void hideForm (Scene obj)
		{
				obj.getWindow().hide();
		}
		public static void setCorrectTittleIcon (ImageView icon)
		{
				String path = String.valueOf(App.class.getResource("/images/title-teach-img-white.png"));
				if(UserSession.getActiveUser().isTeacher()) {
						icon.setImage(new Image(path));
				}
		}

		public static void accessTeacherBtn (Button teacherButton) {
				if (UserSession.getActiveUser().isTeacher()) {
						teacherButton.setVisible(true);
				}
		}


}
