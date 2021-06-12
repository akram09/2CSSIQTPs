package com.neutrix.akram.tlili.domain;

import com.neutrix.akram.tlili.domain.base.UseCase;
import com.neutrix.akram.tlili.domain.models.Film;
import com.neutrix.akram.tlili.domain.repositories.IMainRepository;

public class AddMovie extends UseCase<Film, String> {
    private IMainRepository repository ;

    public AddMovie(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(Film param) {
        return repository.addMovie(param).toString();
    }
}
