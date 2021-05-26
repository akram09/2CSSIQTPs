package com.neutrix.videolibrary.filters;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import com.neutrix.videolibrary.models.Client;
import com.neutrix.videolibrary.models.RentedItem;
import com.neutrix.videolibrary.models.StockItem;

import java.util.*;

public class TransactionProcessorFilter extends Filter {

    public TransactionProcessorFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }


    private TreeMap<String, Client> clients = new TreeMap<>();
    private TreeMap<String, StockItem> stockItems= new TreeMap<>();
    private ArrayList<RentedItem> rentedItems = new ArrayList<>();

    private String applyClient(String action, String args){
        switch (action){
            case "INSERT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    if (parsedArgs.length==2){
                        Client client = new Client(parsedArgs[0], Float.parseFloat(parsedArgs[1]));
                        clients.put(client.getCustomerId(),client);
                        return null;
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
            }
        }
        return null;
    }
    private String applyStockItem(String action, String args){
        switch (action){
            case "INSERT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    if (parsedArgs.length==2){
                        StockItem stockItem = new StockItem(Float.parseFloat(parsedArgs[1]),parsedArgs[0]);
                        stockItems.put(stockItem.getItemId(),stockItem);
                        return null;
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
            }
            case "SELECT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    StringBuilder result = new StringBuilder();
                    // Here the format of select is 'title id'
                    if (parsedArgs.length==1){
                        // here we passed only th title
                        String title = parsedArgs[0];
                        // Obtenir l'ensemble des entrées
                        Collection entrySet = stockItems.entrySet();
                        // Obtenir l'iterator pour parcourir la liste
                        Iterator it = entrySet.iterator();

                        while(it.hasNext()){
                            Map.Entry mentry = (Map.Entry)it.next();
                            StockItem si = this.stockItems.get(mentry.getKey());
                            if(si.getTitle().equals(title)){
                                result.append(si).append("; ");
                            }
                        }
                        if (result.length()==0){
                            result = new StringBuilder("Nothing Was Found");
                        }
                        return result.toString();
                    }

                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
            }
        }
        return null;
    }


    @Override
    public void execute() {
        while (true){
            String input  = getData();
            System.out.println("Calling From Transaction Processor received input '"+ input+"'");
            String[] data  = input.split(";");
            String action = data[0];
            String model = data[1];
            String args = null;
            if (data.length>2){
                args = data[2];
            }
            System.out.println("Detected Input Action: '"+action+"' on Model: '"+model+"' with Args: "+args);
            switch (model){
                case "Client":{
                    String result = applyClient(action,args);
                    System.out.println("Result of the action is: "+result);
                    if (result!=null){
                        sendData(result);
                    }else{
                        sendData("Operation SUCCEEDED");
                    }
                }
                case "StockItem":{
                    String result = applyStockItem(action,args);
                    System.out.println("Result of the action is: "+result);
                    if (result!=null){
                        sendData(result);
                    }else{
                        sendData("Operation SUCCEEDED");
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        execute();
    }
}
