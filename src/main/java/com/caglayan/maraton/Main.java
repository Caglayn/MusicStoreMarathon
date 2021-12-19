package com.caglayan.maraton;

import com.caglayan.maraton.controller.LoginViewController;
import com.caglayan.maraton.controller.UserEntityController;
import com.caglayan.maraton.entities.UserEntity;
import com.caglayan.maraton.utils.CreateSampleData;
import com.caglayan.maraton.utils.ViewUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
//        CreateSampleData.createSample();

//        UserEntityController userEntityController = new UserEntityController();
//        System.out.println(userEntityController.findByName("admin"));

//        for (UserEntity user : userEntityController.list()){
//            System.out.println(user.toString());
//        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initPrimaryStage(primaryStage);
        initRootLayout();
        showLoginView();
    }

    private void initRootLayout() {
        Stage primaryStage = ViewUtil.getInstance().getPrimaryStage();
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/mainView/MainView.fxml"));
            ViewUtil.getInstance().setRootPane(root);
            Scene scene =new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("view/mainView/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            ViewUtil.getInstance().setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initPrimaryStage(Stage primaryStage) {
        ViewUtil.getInstance().setPrimaryStage(primaryStage);
    }

    private void showLoginView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/login/LoginView.fxml"));
        try {
            AnchorPane loginView = (AnchorPane) loader.load();
            ViewUtil.getInstance().getRootPane().setCenter(loginView);
            LoginViewController controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
