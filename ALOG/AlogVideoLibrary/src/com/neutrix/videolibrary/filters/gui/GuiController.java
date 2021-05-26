package com.neutrix.videolibrary.filters.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

public class GuiController extends Application {

    @FXML
    public TextField clientName;

    @FXML
    public TextField clientBalance;

    @FXML
    public Button clientAjouter;


    /////////////    Ajouter Item Stock  ///////////////
    @FXML
    public TextField stockItemTitle;

    @FXML
    public TextField rentalPrice;

    @FXML
    public Button stockItemAjouter;

    @FXML
    public Text result;


    public static final CountDownLatch latch = new CountDownLatch(1);
    public static GuiController controller = null;

    public static GuiController waitForLaunch() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return controller;
    }

    public static GuiController getController() {
        return controller;
    }

    public static void setController(GuiController controller) {
        GuiController.controller = controller;
    }

    public GuiController() {
        setController(this);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Video Library ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        latch.countDown();
    }

}
