package sample.data;


import sample.domain.models.Client;
import sample.domain.models.Film;
import sample.domain.models.RentedItem;
import sample.domain.models.StockItem;
import sample.domain.repositories.IMainRepository;

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
        return transactionProcessor.createClient(client);
    }

    @Override
    public StockItem addStockItem(StockItem item) {
        return transactionProcessor.createStockItem(item);
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
    public List<Client> getClientById(String clientId) {
        return queryProcessor.fetchClientsByID(clientId);
    }

    @Override
    public List<StockItem> getStockItemById(String itemId) {
        return queryProcessor.fetchItemByID(itemId);
    }

    @Override
    public void updateClient(Client client) {
        transactionProcessor.updateClient(client);
    }

    @Override
    public void addRentedItem(RentedItem rentedItem) {
        transactionProcessor.createRentedItem(rentedItem);
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

    @Override
    public String rentItem(RentedItem rentedItem) {
        return transactionProcessor.rentItem(rentedItem);
    }
}
