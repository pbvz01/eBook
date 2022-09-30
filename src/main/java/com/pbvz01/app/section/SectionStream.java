package com.pbvz01.app.section;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SectionStream
{
		private static Section section = SectionActive.getActiveSection();
		private TextArea areaKeywords;
		private TextArea areaMaterial;
		private TextArea areaLinks;

		public SectionStream (TextArea keywords, TextArea material, TextArea links) {
				this.areaMaterial = material;
				this.areaKeywords = keywords;
				this.areaLinks = links;
		}

		public void outputText (Button button) {
				String numTopic  = button.getId().replaceAll("btnTopic", "");
				setTextToMaterial(numTopic, areaMaterial);
				setTextToLink(numTopic, areaLinks);
				setTextToKeyword(numTopic, areaKeywords);
		}

		public void saveChanges(Button button) {
				String numTopic  = button.getId().replaceAll("btnTopic", "");
				saveTextMaterial(numTopic, areaMaterial);
				saveTextKeywords(numTopic, areaKeywords);
				saveTextLink(numTopic, areaLinks);
		}
		private void saveTextLink(String numTopic, TextArea links) {
				Path pathToMaterial = Path.of(section.getPath() + "topic" + numTopic + "/topicLink.txt");
				List<String> lines = Arrays.asList(links.getText().split("\n"));

				try(FileWriter fileWriter = new FileWriter(pathToMaterial.toFile());
				    BufferedWriter writer = new BufferedWriter(fileWriter)) {
						for(int i = 0; i < lines.size(); i++) {
								writer.write(lines.get(i));
								writer.newLine();
						}
				} catch (Exception e){
						System.out.println("Problem with saving of link file");
				}
		}
		private void saveTextKeywords(String numTopic, TextArea key) {
				Path pathToMaterial = Path.of(section.getPath() + "topic" + numTopic + "/topicKey.txt");
				List<String> lines = Arrays.asList(key.getText().split("\n"));

				try(FileWriter fileWriter = new FileWriter(pathToMaterial.toFile());
				    BufferedWriter writer = new BufferedWriter(fileWriter)) {
						for(int i = 0; i < lines.size(); i++) {
								writer.write(lines.get(i));
								writer.newLine();
						}
				} catch (Exception e){}
		}
		private void saveTextMaterial(String numTopic, TextArea material) {
				Path pathToMaterial = Path.of(section.getPath() + "topic" + numTopic + "/topic.txt");

				try(FileWriter fileWriter = new FileWriter(pathToMaterial.toFile());
				    BufferedWriter writer = new BufferedWriter(fileWriter);
				    BufferedReader reader = new BufferedReader(new StringReader(material.getText()))) {
						char[] buff = new char[100];
						while(reader.ready()) {
								int read = reader.read(buff);
								writer.write(buff, 0, read);
								writer.newLine();
						}
				} catch (Exception e){}
		}
		private void setTextToLink(String numTopic, TextArea links)
		{
				Path pathToLinks = Path.of(section.getPath() + "topic" + numTopic + "/topicLink.txt");
				try(StringWriter writer = new StringWriter()) {
						List<String> list = Files.readAllLines(pathToLinks);
						for(String element: list) {
								writer.write(element + "\n");
						}
						links.setText(writer.toString());
				} catch (IOException e) {
						System.out.println("Problem with writing from file Link ");
				}
		}
		private void setTextToKeyword(String numTopic, TextArea keywords) {
				Path pathToLinks = Path.of(section.getPath() + "topic" + numTopic + "/topicKey.txt");
				try(StringWriter writer = new StringWriter()) {
						List<String> list = Files.readAllLines(pathToLinks);
						for(String element: list) {
								writer.write(element + "\n");
						}
						keywords.setText(writer.toString());
				} catch (IOException e) {
						System.out.println("Problem with writing from file Keywords");
				}
		}
		private void setTextToMaterial(String numTopic, TextArea material) {
				Path pathToLinks = Path.of(section.getPath() + "topic" + numTopic + "/topic.txt");
				try(StringWriter writer = new StringWriter()) {
						List<String> list = Files.readAllLines(pathToLinks);
						for(String element: list) {
								writer.write(element);
						}
						material.setText(writer.toString().replaceAll("\t", "\n\t"));
				} catch (IOException e) {
						System.out.println("Problem with writing from file Material");
				}
		}

}
