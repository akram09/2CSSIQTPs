package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.models.StockItem;
import sample.domain.repositories.IMainRepository;

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
