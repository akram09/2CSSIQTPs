package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.UseCase;
import com.neutrix.akram.tlili.domain.models.StockItem;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class AddStockItem extends UseCase<StockItem, String> {
    private IMainRepository repository;

    public AddStockItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(StockItem param) {
        return repository.addStockItem(param).toString();
    }
}
