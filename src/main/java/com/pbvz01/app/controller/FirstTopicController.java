package com.pbvz01.app.controller;

import com.pbvz01.app.section.SectionStream;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.concurrent.atomic.AtomicReference;


public class FirstTopicController extends BasicTopicController
{
		@FXML
		private Button btnTopic1;
		@FXML
		private Button btnTopic2;
		@FXML
		private Button btnTopic3;
		@FXML
		private Button btnTopic4;
		@FXML
		private Button btnTopic5;
		@FXML
		private Button btnTopic6;
		@FXML
		private Button btnTopic7;
		@FXML
		private Button btnTopic8;
		@FXML
		private Button btnTopic9;
		@FXML
		private Button btnTopic10;

		@FXML
		void initialize() {
				settingsForm();
				SectionStream sectionStream =
						  new SectionStream (textFieldKeywords,textFieldMaterial,textFieldLinks);
				AtomicReference<Button> sessionBtn = new AtomicReference<>();

				btnTopic1.setOnAction(event -> {
								sectionStream.outputText(btnTopic1);
								sessionBtn.set(btnTopic1);
						});

				btnTopic2.setOnAction(event -> {
								sectionStream.outputText(btnTopic2);
								sessionBtn.set(btnTopic2);
						});

				btnTopic3.setOnAction(event -> {
						sectionStream.outputText(btnTopic3);
						sessionBtn.set(btnTopic3);
						});

				btnTopic4.setOnAction(event -> {
						sectionStream.outputText(btnTopic4);
						sessionBtn.set(btnTopic4);
						});

				btnTopic5.setOnAction(event -> {
						sectionStream.outputText(btnTopic5);
						sessionBtn.set(btnTopic5);
						});

				btnTopic6.setOnAction(event -> {
						sectionStream.outputText(btnTopic6);
						sessionBtn.set(btnTopic6);
						});

				btnTopic7.setOnAction(event -> {
						sectionStream.outputText(btnTopic7);
						sessionBtn.set(btnTopic7);
						});

				btnTopic8.setOnAction(event -> {
						sectionStream.outputText(btnTopic8);
						sessionBtn.set(btnTopic8);
						});

				btnTopic9.setOnAction(event -> {
						sectionStream.outputText(btnTopic9);
						sessionBtn.set(btnTopic9);
						});

				btnTopic10.setOnAction(event -> {
						sectionStream.outputText(btnTopic10);
						sessionBtn.set(btnTopic10);
						});

				btnTeacherSave.setOnAction(event -> {
								sectionStream.saveChanges(sessionBtn.get());
						});
		}
}

