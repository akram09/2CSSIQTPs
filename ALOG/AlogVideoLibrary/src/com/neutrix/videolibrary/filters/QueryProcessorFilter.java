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
    @Override
    public void execute() {
        while (true){
            String[] data = _dataINPipe.dataOUT().split(" ");
            String method = data[0];
            String args = null;
            if (data.length>1){
                args = data[1];
            }
            switch (method){
                case "addClient":{
                    _dataOUTPipe.dataIN(addClient(args));
                }
            }
        }
    }

    @Override
    public void run() {
        execute();
    }
}