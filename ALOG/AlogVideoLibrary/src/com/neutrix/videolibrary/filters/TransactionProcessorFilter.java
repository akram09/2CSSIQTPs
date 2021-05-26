package com.neutrix.videolibrary.filters;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import com.neutrix.videolibrary.models.Client;
import com.neutrix.videolibrary.models.Film;
import com.neutrix.videolibrary.models.RentedItem;
import com.neutrix.videolibrary.models.StockItem;

import java.time.LocalDate;
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
                        return client.toString();
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
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
                break;
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
                            System.out.println(si);
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
                break;
            }
        }
        return null;
    }

    private String applyFilm(String action, String args){
        switch (action){
            case "INSERT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    System.out.println(parsedArgs);
                    if (parsedArgs.length==3){
                        Film film = new Film(Float.parseFloat(parsedArgs[1]),parsedArgs[0],parsedArgs[2]);
                        stockItems.put(film.getItemId(),film);
                        return null;
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
            }
            case "SELECT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    StringBuilder result = new StringBuilder();
                    // Here the format of select is 'actor id'
                    if (parsedArgs.length==1){
                        // here we passed only th title
                        String actor = parsedArgs[0];
                        // Obtenir l'ensemble des entrées
                        Collection entrySet = stockItems.entrySet();
                        // Obtenir l'iterator pour parcourir la liste
                        Iterator it = entrySet.iterator();

                        while(it.hasNext()){
                            Map.Entry mentry = (Map.Entry)it.next();
                            StockItem si = this.stockItems.get(mentry.getKey());
                            System.out.println(si);
                            if (si instanceof Film){
                                Film f = ((Film) si);
                                if(f.getActeur().equals(actor)){
                                    result.append(f).append("; ");
                                }
                            }
                        }
                        if (result.length()==0){
                            result = new StringBuilder("Nothing Was Found");
                        }
                        return result.toString();
                    }

                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
            }
        }
        return null;
    }

    private String applyRentedItem(String action, String args){
        switch (action){
            case "INSERT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    if (parsedArgs.length==3){
                        if(clients.containsKey(parsedArgs[1]) && stockItems.containsKey(parsedArgs[0])){
                            Client client = clients.get(parsedArgs[1]);
                            StockItem item = stockItems.get(parsedArgs[0]);
                            if (client.getAccountBalance()< item.getRentalPrice()){
                                return "Client Balance isn't suffisiant";
                            }else{
                                client.setAccountBalance(client.getAccountBalance()- item.getRentalPrice());
                                rentedItems.add(new RentedItem(LocalDate.parse(parsedArgs[2]), parsedArgs[1], parsedArgs[0]));
                                return "Operation Succeeded !";
                            }

                        }else{
                            return "Client or Item Not Found ! ";
                        }
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
            }
            case "DELETE":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    if (parsedArgs.length==2){
                        if(clients.containsKey(parsedArgs[1]) && stockItems.containsKey(parsedArgs[0])){
                            for (RentedItem ri:
                                 rentedItems) {
                                if(ri.getItemId().equals(parsedArgs[0]) && ri.getClientId().equals(parsedArgs[1])){
                                    rentedItems.remove(ri);
                                    return "Item returned Successfully !";
                                }
                            }
                            return "Client Has not rented this item ! ";
                        }else{
                            return "Client or Item Not Found ! ";
                        }
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
            }
            case "SELECT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    StringBuilder result = new StringBuilder();
                    // Here the format of select is 'clientId dueDate'
                    if (parsedArgs.length==1){
                        // here we passed only the clientId
                        for (RentedItem ri:rentedItems) {
                            if(ri.getClientId().equals(parsedArgs[0])){
                                result.append(ri).append(" ");
                            }
                        }
                        if (result.length()==0){
                            result = new StringBuilder("Nothing Was Found");
                        }
                        return result.toString();
                    }else if(parsedArgs.length==2){
                        // here we passed the client id and dueDate
                        LocalDate dueDate= LocalDate.parse(parsedArgs[1]);

                        for (RentedItem ri:rentedItems) {
                            if(ri.getClientId().equals(parsedArgs[0]) && ri.getDueDate().compareTo(dueDate)<0){
                                result.append(ri).append(" ");
                            }
                        }
                        if (result.length()==0){
                            result = new StringBuilder("Nothing Was Found");
                        }
                        return result.toString();
                    }
                }
                System.out.println(" The Apply Action resulted in an error Action: "+ action+ " args: "+args);
                break;
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
                    break;
                }
                case "StockItem":{
                    String result = applyStockItem(action,args);
                    System.out.println("Result of the action is: "+result);
                    if (result!=null){
                        sendData(result);
                    }else{
                        sendData("Operation SUCCEEDED");
                    }
                    break;
                }
                case "Film":{
                    String result = applyFilm(action,args);
                    System.out.println("Result of the action is: "+result);
                    if (result!=null){
                        sendData(result);
                    }else{
                        sendData("Operation SUCCEEDED");
                    }
                    break;
                }
                case "RentedItem":{
                    String result = applyRentedItem(action,args);
                    System.out.println("Result of the action is: "+result);
                    if (result!=null){
                        sendData(result);
                    }else{
                        sendData("Operation SUCCEEDED");
                    }
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
