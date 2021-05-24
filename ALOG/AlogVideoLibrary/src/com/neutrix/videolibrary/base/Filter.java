package com.neutrix.videolibrary.base;

public abstract class Filter  implements Runnable{

    public Pipe _dataINPipe;
    public Pipe _dataOUTPipe;

    public String getData(){
        return _dataINPipe.dataOUT();
    }

    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
    public abstract void execute();
}