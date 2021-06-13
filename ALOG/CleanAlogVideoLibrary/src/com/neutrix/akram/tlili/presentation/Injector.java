package com.neutrix.akram.tlili.presentation;

import com.neutrix.akram.tlili.data.Database;
import com.neutrix.akram.tlili.data.MainRepository;
import com.neutrix.akram.tlili.data.QueryProcessor;
import com.neutrix.akram.tlili.data.TransactionProcessor;
import com.neutrix.akram.tlili.domain.AddClientUseCase;
import com.neutrix.akram.tlili.domain.AddStockItem;
import com.neutrix.akram.tlili.domain.RentItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public final class Injector {


    private static MainPresenter presenter;
    /**
     *
     * this will serve as our dependency injector
     * @return
     */
    public static Contract.IMainPresenter injectPresenter(Contract.IMainView view){
        if(presenter==null) {
            Database database = Database.getInstance();
            TransactionProcessor transactionProcessor = new TransactionProcessor(database);
            QueryProcessor queryProcessor = new QueryProcessor(database);
            IMainRepository repository = new MainRepository(transactionProcessor, queryProcessor);
            //   Use cases initialization
            AddClientUseCase addClientUseCase = new AddClientUseCase(repository);
            AddStockItem addStockItem = new AddStockItem(repository);
            RentItem rentItem = new RentItem(repository);
            presenter = new MainPresenter(addClientUseCase,addStockItem , rentItem,view);
            return presenter;
        }else{
            return  presenter;
        }
    }

}
