package com.neutrix.videolibrary;


import com.neutrix.videolibrary.base.BlockingQueue;
import com.neutrix.videolibrary.base.Filter;
import com.neutrix.videolibrary.base.Pipe;
import com.neutrix.videolibrary.filters.QueryProcessorFilter;
import com.neutrix.videolibrary.filters.TransactionProcessorFilter;
import com.neutrix.videolibrary.filters.gui.GuiFilter;

/**
 * Main Entry point for our system
 * - This Java File will launch all the filters and set up pipes
 */
public class Main {
    public static void main(String[] args) {
        Pipe p1 = new BlockingQueue();
        Pipe p2 = new BlockingQueue();
        Pipe p3 = new BlockingQueue();

        Filter a1 = new GuiFilter(p3, p1);
        Filter b1 = new QueryProcessorFilter(p1, p2);
        Filter c1 = new TransactionProcessorFilter(p2, p3);

        Thread th1 = new Thread(a1);
        Thread th2 = new Thread(b1);
        Thread th3 = new Thread(c1);

        th1.start();
        th2.start();
        th3.start();
    }
}
