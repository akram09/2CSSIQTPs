package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.UseCase;
import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class AddClientUseCase extends UseCase<Client,String> {
    private IMainRepository repository;

    public AddClientUseCase(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(Client param) {
        return repository.addClient(param).toString();
    }
}
