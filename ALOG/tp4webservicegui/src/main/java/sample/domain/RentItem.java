package sample.domain;



import sample.domain.base.VoidUseCase;
import sample.domain.errors.ItemNotFound;
import sample.domain.errors.MultipleInstancesFound;
import sample.domain.errors.NotEnoughCredit;
import sample.domain.models.Client;
import sample.domain.models.RentedItem;
import sample.domain.repositories.IMainRepository;

import java.util.List;

public class RentItem extends VoidUseCase<RentedItem> {
    private IMainRepository repository;

    public RentItem(IMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RentedItem param) throws NotEnoughCredit, ItemNotFound, MultipleInstancesFound {
        String result = repository.rentItem(param);
        if(result==null){
            throw new NotEnoughCredit();
        }

    }
}
