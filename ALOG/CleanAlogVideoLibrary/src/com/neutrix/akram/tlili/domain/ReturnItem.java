package com.neutrix.akram.tlili.domain;


import com.neutrix.akram.tlili.domain.base.VoidUseCase;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class ReturnItem extends VoidUseCase<RentedItem> {
    private IMainRepository repository;

    public ReturnItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RentedItem param) throws Exception {
        repository.removeRentedItemByClientItemId(param.getClientId(), param.getItemId());
    }
}
