package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.UserEntity;
import com.caglayan.maraton.utils.ViewUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class SignUpViewController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    private PasswordField txtRepassword;

    @FXML
    private Label lblRepassControl;

    @FXML
    private Button btnSignUp;

    @FXML
    void returnToLoginClicked(ActionEvent event) {
        showLoginView();
    }

    @FXML
    private void initialize(){
        txtRepassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!txtPassword.getText().isBlank()){
                if (txtPassword.getText().equals(newValue)){
                    lblRepassControl.setText("Password ok.");
                    lblRepassControl.setTextFill(Color.GREEN);
                }
                else {
                    lblRepassControl.setText("Passwords do not match !");
                    lblRepassControl.setTextFill(Color.RED);
                }
            }
        });
    }

    @FXML
    void signUpClicked(ActionEvent event) {
        btnSignUp.setDisable(true);
        if (!txtName.getText().isBlank() && !txtLastname.getText().isBlank() && !txtEmail.getText().isBlank() &&
        !txtPhone.getText().isBlank() || !txtPassword.getText().isBlank() && !txtRepassword.getText().isBlank()){
            if (txtRepassword.getText().equals(txtPassword.getText())){
                UserEntityController userEntityController = new UserEntityController();
                UserEntity newUser = new UserEntity().builder().userName(txtName.getText()).userLastname(txtLastname.getText())
                        .eMail(txtEmail.getText()).phoneNumber(txtPhone.getText())
                        .password(txtPassword.getText()).isActive(false).isAdmin(false).build();

                if(userEntityController.findByName(newUser.getUserName()) == null){
                    userEntityController.create(newUser);
                    showLoginView();
                }
                else{
                    showWarningAlert("This user is already exist !");
                    btnSignUp.setDisable(false);
                }
            }
            else {
                showWarningAlert("Passwords do not match !");
                btnSignUp.setDisable(false);
            }
        }
        else {
            showWarningAlert("All fields must be filled !");
            btnSignUp.setDisable(false);
        }
    }

    private void showLoginView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/login/LoginView.fxml"));
        try {
            AnchorPane loginView = (AnchorPane) loader.load();
//            ViewUtil.getInstance().getPrimaryStage().setWidth(750);
//            ViewUtil.getInstance().getPrimaryStage().setHeight(450);
            ViewUtil.getInstance().getRootPane().setCenter(loginView);
            LoginViewController controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showWarningAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning..!");
        alert.setHeaderText(message);
        alert.show();
    }

}
