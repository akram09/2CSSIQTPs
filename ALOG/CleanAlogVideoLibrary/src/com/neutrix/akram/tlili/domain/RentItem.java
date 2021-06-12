package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.VoidUseCase;
import com.neutrix.akram.tlili.domain.errors.NotEnoughCredit;
import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class RentItem extends VoidUseCase<RentedItem> {
    private IMainRepository repository;

    public RentItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RentedItem param) throws NotEnoughCredit {
        Client client  = repository.getClientById(param.getClientId());
        StockItem stockItem = repository.getStockItemById(param.getItemId());
        if(client.getAccountBalance()< stockItem.getRentalPrice()){
            throw new NotEnoughCredit();
        }else{
            client.setAccountBalance(client.getAccountBalance()-stockItem.getRentalPrice());
            repository.updateClient(client);
            repository.addRentedItem(param);
        }
    }
}
