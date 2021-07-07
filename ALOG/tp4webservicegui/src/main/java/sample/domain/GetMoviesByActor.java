package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.repositories.IMainRepository;

public class GetMoviesByActor extends UseCase<String, String> {
    private IMainRepository repository;

    public GetMoviesByActor(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String param) {
        return repository.getMovieByActor(param).toString();
    }
}
