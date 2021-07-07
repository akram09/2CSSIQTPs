package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.repositories.IMainRepository;

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
