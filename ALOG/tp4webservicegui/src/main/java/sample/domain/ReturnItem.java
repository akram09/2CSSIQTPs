package sample.domain;


import sample.domain.base.VoidUseCase;
import sample.domain.models.RentedItem;
import sample.domain.repositories.IMainRepository;

public class ReturnItem extends VoidUseCase<RentedItem> {
    private IMainRepository repository;

    public ReturnItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RentedItem param) throws Exception {
        repository.removeRentedItemByClientItemId(param.getClientId(), param.getItemId());
    }
}
