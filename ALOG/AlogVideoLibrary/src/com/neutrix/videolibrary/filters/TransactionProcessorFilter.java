package com.neutrix.videolibrary.filters;

import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import com.neutrix.videolibrary.models.Client;
import com.neutrix.videolibrary.models.Model;
import com.neutrix.videolibrary.models.StockItem;

import java.util.ArrayList;
import java.util.List;

public class TransactionProcessorFilter extends Filter {
    public TransactionProcessorFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }
    private List<Client> clients = new ArrayList<>();
    private List<StockItem> items = new ArrayList<>();



    private String applyClient(String action, String args){
        switch (action){
            case "INSERT":{
                if (args !=null ){
                    String[] parsedArgs = args.split(" ");
                    if (parsedArgs.length==2){
                        Client client = new Client(parsedArgs[0], Float.parseFloat(parsedArgs[1]));
                        clients.add(client);
                        return null;
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
            String[] data  = _dataINPipe.dataOUT().split(" ");
            String action = data[0];
            String model = data[1];
            String args = null;
            if (data.length>2){
                args = data[3];
            }
            switch (model){
                case "Client":{
                    String result = applyClient(action,args);
                    if (result!=null){
                        _dataOUTPipe.dataIN(result);
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
