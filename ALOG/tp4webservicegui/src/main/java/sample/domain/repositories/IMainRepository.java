package sample.domain.repositories;


import sample.domain.models.Client;
import sample.domain.models.Film;
import sample.domain.models.RentedItem;
import sample.domain.models.StockItem;

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
    String rentItem(RentedItem rentedItem);

}
