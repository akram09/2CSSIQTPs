package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.VoidUseCase;
import com.neutrix.akram.tlili.domain.errors.ItemNotFound;
import com.neutrix.akram.tlili.domain.errors.MultipleInstancesFound;
import com.neutrix.akram.tlili.domain.errors.NotEnoughCredit;
import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

import java.util.List;

public class RentItem extends VoidUseCase<RentedItem> {
    private IMainRepository repository;

    public RentItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RentedItem param) throws NotEnoughCredit, ItemNotFound, MultipleInstancesFound {
        List<Client> clients  = repository.getClientById(param.getClientId());
        List<StockItem> stockItems = repository.getStockItemById(param.getItemId());
        if (clients.size()<1){
            throw new ItemNotFound("Client");
        }
        if(stockItems.size()<1){
            throw new ItemNotFound("Stock Item");
        }
        if (clients.size()> 1){
            throw new MultipleInstancesFound();
        }
        if(stockItems.size()>1){
            throw  new MultipleInstancesFound();
        }
        Client client = clients.get(0);
        StockItem stockItem = stockItems.get(0);
        if(client.getAccountBalance()< stockItem.getRentalPrice()){
            throw new NotEnoughCredit();
        }else{
            client.setAccountBalance(client.getAccountBalance()-stockItem.getRentalPrice());
            repository.updateClient(client);
            repository.addRentedItem(param);
        }
    }
}
