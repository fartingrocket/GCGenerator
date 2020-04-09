package com.gcgenerator;

import com.gcgenerator.controllers.MainController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	private Stage stage;
	private FXMLLoader loader = new FXMLLoader();
    private BorderPane root;
    private Scene scene;

	@Override
	public void start(Stage primaryStage) {

		this.stage = primaryStage;
		this.stage.setTitle("GCGenerator");

		initRootLayout();
	}

	public void initRootLayout(){
		try {
			this.loader.setLocation(Main.class.getResource("views/Main.fxml"));
			this.root = (BorderPane) loader.load();
			this.scene = new Scene(root,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			MainController controller = loader.getController();
	        controller.setMainApp(this);

			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

    public void openBrowser(ActionEvent actionEvent) throws Exception {

        getHostServices().showDocument("https://github.com/hbenniou");

    }

    public void about(){
		FXMLLoader newLoader = new FXMLLoader();

		try {
			newLoader.setLocation(Main.class.getResource("views/About.fxml"));
			StackPane aboutLayout = (StackPane) newLoader.load();
			Scene secondScene = new Scene(aboutLayout);
			secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Stage newWindow = new Stage();
			newWindow.setTitle("About GCGenerator");
			newWindow.setScene(secondScene);

            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.initOwner(stage);

			newWindow.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	public Stage getStage(){
		return this.stage;
	}
}
