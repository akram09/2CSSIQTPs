package com.neutrix.videolibrary.filters.gui;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import javafx.application.Application;
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
        controller.clientAjouter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name  = controller.clientName.getText();
                float balance  = Float.parseFloat(controller.clientBalance.getText());
                List<String> data = new ArrayList<>();
                data.add(name);
                data.add(String.valueOf(balance));
                _dataOUTPipe.dataIN(format("addClient",data ));
            }
        });
    }
}
