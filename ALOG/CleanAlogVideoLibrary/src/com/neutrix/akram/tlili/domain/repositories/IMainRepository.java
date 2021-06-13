package com.neutrix.akram.tlili.domain.repositories;

import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.Film;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;

import java.util.List;

public interface IMainRepository {
    Client addClient(Client client);
    StockItem addStockItem(StockItem item);
    Film addMovie(Film movie);
    List<StockItem> getStockItems(String title);
    List<Film> getMovieByActor(String actor);
    List<Client> getClientById(String clientId);
    List<StockItem> getStockItemById(String itemId);
    void updateClient(Client client);
    void addRentedItem(RentedItem rentedItem);
    void removeRentedItemByClientItemId(String clientId, String itemId);
    List<RentedItem> getRentedItems(String clientId);
    List<RentedItem> getLateRentedItems(String clientId);

}
