package sample.presentation;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import sample.data.MainRepository;
import sample.data.QueryProcessor;
import sample.data.TransactionProcessor;
import sample.domain.AddClientUseCase;
import sample.domain.AddStockItem;
import sample.domain.RentItem;
import sample.domain.repositories.IMainRepository;

public final class Injector {


    private static MainPresenter presenter;
    /**
     *
     * this will serve as our dependency injector
     * @return
     */
    public static Contract.IMainPresenter injectPresenter(Contract.IMainView view){
        if(presenter==null) {
            OkHttpClient client = new OkHttpClient();
            Gson gson = new Gson();
            TransactionProcessor transactionProcessor = new TransactionProcessor(client,gson);
            QueryProcessor queryProcessor = new QueryProcessor(client);
            IMainRepository repository = new MainRepository(transactionProcessor, queryProcessor);
            //   Use cases initialization
            AddClientUseCase addClientUseCase = new AddClientUseCase(repository);
            AddStockItem addStockItem = new AddStockItem(repository);
            RentItem rentItem = new RentItem(repository);
            presenter = new MainPresenter(addClientUseCase,addStockItem , rentItem,view);
            return presenter;
        }else{
            return  presenter;
        }
    }

}
