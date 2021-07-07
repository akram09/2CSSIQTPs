package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.repositories.IMainRepository;

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
