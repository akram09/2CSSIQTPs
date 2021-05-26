package com.neutrix.videolibrary.filters.gui;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
        });
        controller.afficherItemsTitle.setOnAction(event -> {
            String title  = controller.stockItemQueryTitle.getText();
            List<String> data = new ArrayList<>();
            data.add(title);
            String dataOut = format("queryStockItem",data );
            System.out.println(dataOut);
            sendData(dataOut);
        });
    }
}
