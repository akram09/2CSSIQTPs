package com.neutrix.akram.tlili.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class MainController implements Contract.IMainView {



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


    @FXML
    public void addClientClicked(ActionEvent event) throws IOException {
        String name  = clientName.getText();
        float balance  = Float.parseFloat(clientBalance.getText());
        Injector.injectPresenter(this).addClient(balance, name);
    }
    @FXML
    public void addStockItemClicked(ActionEvent event) throws IOException {
        String title  = stockItemTitle.getText();
        float rentPrice  = Float.parseFloat(rentalPrice.getText());
        Injector.injectPresenter(this).addStockItem(rentPrice,title);
    }

    @FXML
    public void rentStockItem(ActionEvent event) throws IOException {
        String itemId  = rentItemId.getText();
        String clientId  = rentClientId.getText();
        LocalDate dueDate = rentDueDate.getValue();
        Injector.injectPresenter(this).rentItem(itemId,clientId,dueDate);
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
}
