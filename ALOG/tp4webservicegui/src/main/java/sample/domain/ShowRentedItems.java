package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.repositories.IMainRepository;

public class ShowRentedItems extends UseCase<String, String> {
    private IMainRepository repository;

    public ShowRentedItems(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String param) {
        return repository.getRentedItems(param).toString();
    }
}
