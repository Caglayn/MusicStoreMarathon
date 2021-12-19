package com.caglayan.maraton.controller;

import com.caglayan.maraton.utils.AccountUtil;
import com.caglayan.maraton.utils.ViewUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginViewController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void loginAction(ActionEvent event) {
        String username = "";
        String password = "";
        if (this.txtUsername.getText().isEmpty() || this.txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning..!");
            alert.setHeaderText("Please fill all fields !");
            alert.show();
        }
        else{
            username = this.txtUsername.getText();
            password = this.txtPassword.getText();
            UserEntityController userEntityController = new UserEntityController();
            if (userEntityController.LoginWithUsernameAndPassword(username,password)){
                if (AccountUtil.getInstance().getActiveUser().getIsAdmin()){
                    showAdminView();
                }
                else {
                    showUserView();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning..!");
                alert.setHeaderText("Wrong username or password !");
                alert.show();
            }
        }
    }

    @FXML
    void signUpAction(ActionEvent event) {
        showUserView();
    }

    private void showAdminView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/admin/AdminView.fxml"));
        try {
            AnchorPane adminView = (AnchorPane) loader.load();
            ViewUtil.getInstance().getPrimaryStage().setWidth(750);
            ViewUtil.getInstance().getPrimaryStage().setHeight(450);
//            ViewUtil.getInstance().getRootPane().setPrefSize(750, 450);
            ViewUtil.getInstance().getRootPane().setCenter(adminView);
            AdminViewController controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showUserView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/user/UserView.fxml"));
        try {
            AnchorPane userView = (AnchorPane) loader.load();
            ViewUtil.getInstance().getRootPane().setCenter(userView);
            UserViewController controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
