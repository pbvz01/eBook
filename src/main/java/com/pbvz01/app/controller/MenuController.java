package com.pbvz01.app.controller;

import com.pbvz01.app.constants.ControllerConst;
import com.pbvz01.app.form_manager.FormManager;
import com.pbvz01.app.section.Section;
import com.pbvz01.app.section.SectionActive;
import com.pbvz01.app.section.SectionFactory;
import com.pbvz01.app.section.SectionNumber;
import com.pbvz01.app.user.User;
import com.pbvz01.app.user.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MenuController
{
		private User user = UserSession.getActiveUser();

		@FXML
		private ImageView icon;
		@FXML
		private Text textInfo;
		@FXML
		private Button topicBtn1;
		@FXML
		private Button topicBtn2;
		@FXML
		private Button topicBtn3;
		@FXML
		private Button topicBtn4;
		@FXML
		private Button topicBtn5;
		@FXML
		private Button topicBtn6;
		@FXML
		private Button topicBtn7;
		@FXML
		void initialize()
		{
				FormManager.setCorrectTittleIcon(icon);
				textInfo.setText(textInfo.getText() + " " + user.getName());

				topicBtn1.setOnAction(event ->
						{
								Section section = SectionFactory.getSection(SectionNumber.SECTION1);
								SectionActive.setActiveSection(section);
								FormManager.hideForm(topicBtn1.getScene());
								FormManager.createNewForm(ControllerConst.FIRST_TOPIC_FORM);
						});

		}


}


