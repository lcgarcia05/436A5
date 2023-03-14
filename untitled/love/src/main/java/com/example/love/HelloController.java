package com.example.love;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label essay;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button bt;

    @FXML
    private Button bt2;

    @FXML
    private ImageView img;

    @FXML
    private ImageView wu;
    @FXML
    private ImageView boba;
    @FXML
    private ImageView pizza;

    @FXML
    private Label lastGreet;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("HAPPY ANNIVERSARY LOVE!");
    }

    @FXML
    protected void onClickHide(){
        bt.setVisible(false);
        bt2.setVisible(true);
    }


    @FXML
    protected void onCickMeButtonClick(){
        img.setVisible(true);
        essay.setText("Happy Anniversary Love! Sorry na medyo late hehehe. wag na tampo!! hmmpp!! Eto na yung effort kahit medyo baduy hehe " +
                "sorry medyo natagalan, mygad nakalimutan ko na agad pano gumawa ng GUI eh hahaha. Hanggang ganto muna kaya ko love " +
                "hehehe sa susunod talga promise magksama na natin iccelebrate to! hehehe. Wag na tampo please?? And thank you padin " +
                "sa walang sawa pag tiis sakin hehehe. Kahit na sobrang dry ko nga kamo hmmp! sorry na ganun lng tlg me eh hehe. " +
                "for sure pag magksama naman mas ma-eexpress ko na yung mga gusto mo with actions hehehe. Lika na kasi dito hmp!! " +
                "hehehe. Tagal kasi pumunta hmp!! pero try mo na baguhin isip mo na pmnta dto ah love? pra mas madali and di kana ma- " +
                "hihirapan. Wag ka na din matakot kasi hindi naman kita papabayaan! hehe. Osya di ko na pahabain love eexplore mo din naman " +
                "tong application haha. I love you so much love! and I miss you soooooooooooo much! Happy Anniversary ulit!");
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene6(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene6.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickWuShow(){
        boba.setVisible(true);
        pizza.setVisible(true);
        wu.setVisible(true);
        lastGreet.setVisible(true);
    }
}