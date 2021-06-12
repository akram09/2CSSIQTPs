package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.UseCase;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class ShowLateRentedItems extends UseCase<String, String> {
    private IMainRepository repository;

    public ShowLateRentedItems(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String param) {
        return repository.getLateRentedItems(param).toString();
    }
}
