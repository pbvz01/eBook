package com.pbvz01.app.controller;

import com.pbvz01.app.constants.ControllerConst;
import com.pbvz01.app.form_manager.FormManager;
import com.pbvz01.app.section.Section;
import com.pbvz01.app.section.SectionActive;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.util.concurrent.atomic.AtomicBoolean;

public class BasicTopicController
{
		protected static Section section = SectionActive.getActiveSection();
		@FXML
		protected ImageView icon;

		@FXML
		protected TextArea textFieldKeywords;

		@FXML
		protected TextArea textFieldLinks;

		@FXML
		protected TextArea textFieldMaterial;

		@FXML
		protected CheckBox checkBox1;

		@FXML
		protected CheckBox checkBox2;

		@FXML
		protected CheckBox checkBox3;

		@FXML
		protected Button btnTeacherStart;

		@FXML
		protected Button btnTeacherSave;

		@FXML
		protected Label headerText;

		@FXML
		protected Button btnBack;

		protected void settingsForm()
		{
				logicButtonBack();
				logicButtonTeacher();
				logicCheckBoxForSizeText();

				headerText.setText(section.getTitle());
				FormManager.setCorrectTittleIcon(icon);
				FormManager.accessTeacherBtn(btnTeacherStart);

		}

		private void logicButtonTeacher()
		{
				AtomicBoolean checkBtnTeacher = new AtomicBoolean(false);

				btnTeacherStart.setOnAction(event ->
						{
								if(!checkBtnTeacher.get())
								{
										btnTeacherSave.setVisible(true);
										btnTeacherStart.setText("Сховати кнопки");
										checkBtnTeacher.set(true);
										textFieldMaterial.setEditable(true);
										textFieldLinks.setEditable(true);
										textFieldKeywords.setEditable(true);
								}
								else if(checkBtnTeacher.get())
								{
										btnTeacherSave.setVisible(false);
										btnTeacherStart.setText("Розпочати редактування");
										checkBtnTeacher.set(false);
										textFieldMaterial.setEditable(false);
										textFieldLinks.setEditable(false);
										textFieldKeywords.setEditable(false);
								}
						});
		}

		private void logicButtonBack()
		{
				btnBack.setOnAction(event ->
						{
								FormManager.hideForm(btnBack.getScene());
								FormManager.createNewForm(ControllerConst.MENU_FORM);
						});
		}

		private void logicCheckBoxForSizeText()
		{
				checkBox1.setOnAction(event ->
						{
								checkBox2.setSelected(false);
								checkBox3.setSelected(false);
								textFieldLinks.setFont(new Font(12));
								textFieldKeywords.setFont(new Font(12));
								textFieldMaterial.setFont(new Font(12));
						});

				checkBox2.setOnAction(event ->
						{
								checkBox1.setSelected(false);
								checkBox3.setSelected(false);
								textFieldLinks.setFont(new Font(14));
								textFieldKeywords.setFont(new Font(14));
								textFieldMaterial.setFont(new Font(14));
						});

				checkBox3.setOnAction(event ->
						{
								checkBox1.setSelected(false);
								checkBox2.setSelected(false);
								textFieldLinks.setFont(new Font(16));
								textFieldKeywords.setFont(new Font(16));
								textFieldMaterial.setFont(new Font(16));
						});
		}
}
