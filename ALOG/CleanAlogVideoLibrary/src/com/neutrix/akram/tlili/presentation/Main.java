package com.neutrix.akram.tlili.presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class Main extends Application implements Contract.IMainView {


    // Presenter
    private Contract.IMainPresenter presenter;


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

    /////////////    Ajouter Film  ///////////////
    @FXML
    public TextField filmTitle;

    @FXML
    public TextField filmrentalPrice;

    @FXML
    public TextField filmActeur;

    @FXML
    public Button filmAjouter;

    ///////////////   Afficher les articles par titre   ///////////
    @FXML
    public TextField stockItemQueryTitle;
    @FXML
    public Button afficherItemsTitle;
    ///////////////   Afficher les filmes par acteur   ///////////
    @FXML
    public TextField filmQueryActor;
    @FXML
    public Button afficherFilmsActeur;

    ////////////    Louer un article   /////////
    @FXML
    public TextField rentClientId;
    @FXML
    public DatePicker rentDueDate;
    @FXML
    public TextField rentItemId;

    @FXML
    public Button rentItem;

    ////////////    Remettre Un Item   /////////
    @FXML
    public TextField returnClientId;
    @FXML
    public TextField returnItemId;

    @FXML
    public Button returnItem;

    ////////////    Afficher les articles Loués par client   /////////
    @FXML
    public TextField queryRentedClientId;
    @FXML
    public Button queryRentedClient;

    ////////////    Afficher les articles retard Loués par client   /////////
    @FXML
    public TextField queryRentedLateClientId;
    @FXML
    public Button queryRentedLateClient;



    @FXML
    public TextArea result;



    private void initialize(){
        presenter = new MainPresenter();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../../../../resources/sample.fxml")));
        primaryStage.setTitle("Alog Video Library");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        initialize();

        // set up callback to bind presenter
        setUpViewCallback();
    }


    /**
     * Set Up View Callback like click listener
     */
    private void setUpViewCallback(){
        clientAjouter.setOnAction(event -> {
            String name  = clientName.getText();
            float balance  = Float.parseFloat(clientBalance.getText());
            presenter.addClient(balance, name);
        });
        stockItemAjouter.setOnAction(event -> {
            String title  = stockItemTitle.getText();
            float rentPrice  = Float.parseFloat(rentalPrice.getText());
            presenter.addStockItem(rentPrice,title);
        });
        filmAjouter.setOnAction(event -> {
            String title  = filmTitle.getText();
            String actor  = filmActeur.getText();
            float rentalPrice  = Float.parseFloat(filmrentalPrice.getText());
            presenter.addMovie(rentalPrice,title,actor);
        });
        afficherItemsTitle.setOnAction(event -> {
            String title  = stockItemQueryTitle.getText();
            presenter.showStockItemByTitle(title);
        });
        afficherFilmsActeur.setOnAction(event -> {
            String actor  = filmQueryActor.getText();
            presenter.showMovieByActor(actor);
        });
        rentItem.setOnAction(event -> {
            String itemId  = rentItemId.getText();
            String clientId  = rentClientId.getText();
            LocalDate dueDate = rentDueDate.getValue();
            presenter.rentItem(itemId,clientId,dueDate);
        });
        returnItem.setOnAction(event -> {
            String itemId  = returnItemId.getText();
            String clientId  = returnClientId.getText();
            presenter.returnItem(itemId,clientId);
        });
        queryRentedClient.setOnAction(event -> {
            String clientId  = queryRentedClientId.getText();
            presenter.showRentedItemsByClient(clientId);
        });
        queryRentedLateClientId.setOnAction(event -> {
            String clientId  = queryRentedLateClient.getText();
            presenter.showRentedItemsLateByClient(clientId);
        });
    }


    @Override
    public void showOperationResult(String operationResult) {
        result.setText(operationResult);
    }

    @Override
    public void clearText() {
        stockItemQueryTitle.clear();
        filmQueryActor.clear();
        filmActeur.clear();
        filmrentalPrice.clear();
        filmTitle.clear();
        rentalPrice.clear();
        stockItemTitle.clear();
        clientName.clear();
        clientBalance.clear();
        rentClientId.clear();
        rentItemId.clear();
        returnItemId.clear();
        returnClientId.clear();
        queryRentedClientId.clear();
        queryRentedLateClientId.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
