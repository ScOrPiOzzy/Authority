package com.cas.authority.javafx;

import java.net.URL;

import com.cas.authority.javafx.controller.UserRegistController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class RegistApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			URL location = getClass().getResource("/fxml/ResiterUI.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(location);
			fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
			Parent root = (javafx.scene.Parent) fxmlLoader.load(location.openStream());
			UserRegistController control = (UserRegistController) fxmlLoader.getController();
			control.setStage(primaryStage);

			Scene scene = new Scene(root, 400, 320);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hello World");
			primaryStage.setResizable(false);
//			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/earth.png")));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
