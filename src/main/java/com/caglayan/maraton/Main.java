package com.caglayan.maraton;

import com.caglayan.maraton.controller.UserEntityController;
import com.caglayan.maraton.entities.UserEntity;
import com.caglayan.maraton.utils.CreateSampleData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        initLayout(primaryStage);
    }

    private void initLayout(Stage primaryStage){
        try {
            BorderPane root =(BorderPane) FXMLLoader.load(getClass().getResource("view/mainview/Mainview.fxml"));
            Scene scene =new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("view/mainview/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMainview(){
        FXMLLoader loader = new FXMLLoader();
    }
}
