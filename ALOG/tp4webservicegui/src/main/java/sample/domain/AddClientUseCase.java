package sample.domain;


import sample.domain.base.UseCase;
import sample.domain.models.Client;
import sample.domain.repositories.IMainRepository;

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
