package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.UseCase;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class GetStockItemsByTitle extends UseCase<String , String> {
    private IMainRepository repository;

    public GetStockItemsByTitle(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String param) {
        return repository.getStockItems(param).toString();
    }
}
