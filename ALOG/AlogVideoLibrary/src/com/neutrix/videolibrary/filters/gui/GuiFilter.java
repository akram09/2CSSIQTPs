package com.neutrix.videolibrary.filters.gui;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuiFilter extends Filter {

    private GuiController controller;

    public GuiFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    @Override
    public void run() {
        execute();
    }


    private String format(String method, List<String> data ){
        return method+";"+String.join(" ",data);
    }

    @Override
    public void execute() {
        new Thread(() -> Application.launch(GuiController.class)).start();
        controller = GuiController.waitForLaunch();
        new Thread(() -> {
            while (true){
                String input  = getData();
                System.out.println("Calling From GUI received input '"+ input+"'");
                Platform.runLater(() -> controller.result.setText(input));
            }
        }).start();


        controller.clientAjouter.setOnAction(event -> {
            String name  = controller.clientName.getText();
            float balance  = Float.parseFloat(controller.clientBalance.getText());
            List<String> data = new ArrayList<>();
            data.add(name);
            data.add(String.valueOf(balance));
            String dataOut = format("addClient",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.stockItemAjouter.setOnAction(event -> {
            String title  = controller.stockItemTitle.getText();
            float rentalPrice  = Float.parseFloat(controller.rentalPrice.getText());
            List<String> data = new ArrayList<>();
            data.add(title);
            data.add(String.valueOf(rentalPrice));
            String dataOut = format("addStockItem",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.filmAjouter.setOnAction(event -> {
            String title  = controller.filmTitle.getText();
            String actor  = controller.filmActeur.getText();
            float rentalPrice  = Float.parseFloat(controller.filmrentalPrice.getText());
            List<String> data = new ArrayList<>();
            data.add(title);
            data.add(String.valueOf(rentalPrice));
            data.add(actor);
            String dataOut = format("addFilm",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.afficherItemsTitle.setOnAction(event -> {
            String title  = controller.stockItemQueryTitle.getText();
            List<String> data = new ArrayList<>();
            data.add(title);
            String dataOut = format("queryStockItem",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.afficherFilmsActeur.setOnAction(event -> {
            String title  = controller.filmQueryActor.getText();
            List<String> data = new ArrayList<>();
            data.add(title);
            String dataOut = format("queryFilm",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.rentItem.setOnAction(event -> {
            String itemId  = controller.rentItemId.getText();
            String clientId  = controller.rentClientId.getText();
            LocalDate dueDate = controller.rentDueDate.getValue();
            List<String> data = new ArrayList<>();
            data.add(itemId);
            data.add(clientId);
            data.add(dueDate.toString());
            String dataOut = format("rentItem",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.returnItem.setOnAction(event -> {
            String itemId  = controller.returnItemId.getText();
            String clientId  = controller.returnClientId.getText();
            List<String> data = new ArrayList<>();
            data.add(itemId);
            data.add(clientId);
            String dataOut = format("returnItem",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });

        controller.queryRentedClient.setOnAction(event -> {
            String clientId  = controller.queryRentedClientId.getText();
            List<String> data = new ArrayList<>();
            data.add(clientId);
            String dataOut = format("getClientRented",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });
        controller.queryRentedLateClientId.setOnAction(event -> {
            String clientId  = controller.queryRentedLateClient.getText();
            List<String> data = new ArrayList<>();
            data.add(clientId);
            String dataOut = format("getClientLateRented",data );
            System.out.println(dataOut);
            sendData(dataOut);
            clearAllText();
        });

    }



    public void clearAllText(){
        controller.stockItemQueryTitle.clear();
        controller.filmQueryActor.clear();
        controller.filmActeur.clear();
        controller.filmrentalPrice.clear();
        controller.filmTitle.clear();
        controller.rentalPrice.clear();
        controller.stockItemTitle.clear();
        controller.clientName.clear();
        controller.clientBalance.clear();
        controller.rentClientId.clear();
        controller.rentItemId.clear();
        controller.returnItemId.clear();
        controller.returnClientId.clear();
        controller.queryRentedClientId.clear();
        controller.queryRentedLateClientId.clear();
    }
}
