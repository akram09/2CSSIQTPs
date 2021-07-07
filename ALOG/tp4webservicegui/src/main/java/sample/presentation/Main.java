package sample.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        URL fxml = getClass().getClassLoader().getResource("sample.fxml");
        Parent root = FXMLLoader.load(fxml);
        primaryStage.setTitle("Video Game Store ALOG");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    /**
     * Set Up View Callback like click listener
     */
    private void setUpViewCallback(){
        /*
        controller.filmAjouter.setOnAction(event -> {
            String title  = controller.filmTitle.getText();
            String actor  = controller.filmActeur.getText();
            float rentalPrice  = Float.parseFloat(controller.filmrentalPrice.getText());
            presenter.addMovie(rentalPrice,title,actor);
        });
        controller.afficherItemsTitle.setOnAction(event -> {
            String title  = controller.stockItemQueryTitle.getText();
            presenter.showStockItemByTitle(title);
        });
        controller.afficherFilmsActeur.setOnAction(event -> {
            String actor  = controller.filmQueryActor.getText();
            presenter.showMovieByActor(actor);
        });
        controller.returnItem.setOnAction(event -> {
            String itemId  = controller.returnItemId.getText();
            String clientId  = controller.returnClientId.getText();
            presenter.returnItem(itemId,clientId);
        });
        controller.queryRentedClient.setOnAction(event -> {
            String clientId  = controller.queryRentedClientId.getText();
            presenter.showRentedItemsByClient(clientId);
        });
        controller.queryRentedLateClientId.setOnAction(event -> {
            String clientId  = controller.queryRentedLateClient.getText();
            presenter.showRentedItemsLateByClient(clientId);
        });*/
    }




    public static void main(String[] args) {
        launch(args);
    }
}
