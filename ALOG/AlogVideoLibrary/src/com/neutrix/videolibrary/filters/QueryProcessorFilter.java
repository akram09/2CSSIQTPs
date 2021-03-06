package com.neutrix.videolibrary.filters;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;

import java.util.List;

public class QueryProcessorFilter extends Filter {
    public QueryProcessorFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    private String format(String action, String model, String args){
        return action+ ";" + model+";"+ args;
    }

    private String addClient(String args){
        return format("INSERT", "Client", args);
    }
    private String queryStockItems(String args){
        return format("SELECT", "StockItem", args);
    }
    private String addStockItem(String args){
        return format("INSERT", "StockItem", args);
    }
    private String queryFilm(String args){
        return format("SELECT", "Film", args);
    }
    private String addFilm(String args){
        return format("INSERT", "Film", args);
    }
    private String rentItem(String args){
        return format("INSERT", "RentedItem", args);
    }
    private String returnItem(String args){
        return format("DELETE", "RentedItem", args);
    }
    private String queryRentedItems(String args){
        return format("SELECT", "RentedItem", args);
    }
    private String queryRentedLateItems(String args){
        return format("SELECT", "RentedItem", args);
    }
    @Override
    public void execute() {
        while (true){
            String input  = _dataINPipe.dataOUT();
            String[] data = input.split(";");
            for (String d:
                 data) {
                System.out.println(d);
            }
            String method = data[0];
            String args = null;
            if (data.length>1){
                args = data[1];
            }
            System.out.println("Calling From Query Processor received input '"+ input+"'");
            System.out.println("Detected method '"+ method+ "' And arguments passed: " + args);

            switch (method){
                case "addClient":{
                    sendData(addClient(args));
                    break;
                }
                case "addStockItem":{
                    sendData(addStockItem(args));
                    break;
                }
                case "queryStockItem":{
                    sendData(queryStockItems(args));
                    break;
                }
                case "addFilm":{
                    sendData(addFilm(args));
                    break;
                }
                case "queryFilm":{
                    sendData(queryFilm(args));
                    break;
                }
                case "rentItem":{
                    sendData(rentItem(args));
                    break;
                }
                case "returnItem":{
                    sendData(returnItem(args));
                    break;
                }
                case "getClientRented":{
                    sendData(queryRentedItems(args));
                    break;
                }
                case "getClientLateRented":{
                    sendData(queryRentedLateItems(args));
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        execute();
    }
}
