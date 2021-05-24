package com.neutrix.videolibrary.base;

import java.util.LinkedList;
import java.util.Queue;

public class PipeQueue extends Pipe {

    Queue<String> _inData = new LinkedList();

    public void dataIN (String in){
        _inData.add(in);
    }

    public String dataOUT (){
        return _inData.poll();
    }

}
