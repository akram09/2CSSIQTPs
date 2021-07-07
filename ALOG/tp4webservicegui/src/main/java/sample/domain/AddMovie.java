package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.models.Film;
import sample.domain.repositories.IMainRepository;

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
