package com.neutrix.akram.tlili.data;

import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.Film;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

import java.util.List;

public class MainRepository implements IMainRepository {
    private TransactionProcessor transactionProcessor;
    private QueryProcessor queryProcessor;

    public MainRepository(TransactionProcessor transactionProcessor, QueryProcessor queryProcessor) {
        this.transactionProcessor = transactionProcessor;
        this.queryProcessor = queryProcessor;
    }


    @Override
    public Client addClient(Client client) {
        return null;
    }

    @Override
    public StockItem addStockItem(StockItem item) {
        return null;
    }

    @Override
    public Film addMovie(Film movie) {
        return null;
    }

    @Override
    public List<StockItem> getStockItems(String title) {
        return null;
    }

    @Override
    public List<Film> getMovieByActor(String actor) {
        return null;
    }

    @Override
    public Client getClientById(String clientId) {
        return null;
    }

    @Override
    public StockItem getStockItemById(String itemId) {
        return null;
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void addRentedItem(RentedItem rentedItem) {

    }

    @Override
    public void removeRentedItemByClientItemId(String clientId, String itemId) {

    }

    @Override
    public List<RentedItem> getRentedItems(String clientId) {
        return null;
    }

    @Override
    public List<RentedItem> getLateRentedItems(String clientId) {
        return null;
    }
}
