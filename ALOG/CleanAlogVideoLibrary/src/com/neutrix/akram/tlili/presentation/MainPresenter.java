package com.neutrix.akram.tlili.presentation;

import com.neutrix.akram.tlili.domain.AddClientUseCase;
import com.neutrix.akram.tlili.domain.AddStockItem;
import com.neutrix.akram.tlili.domain.RentItem;
import com.neutrix.akram.tlili.domain.errors.ItemNotFound;
import com.neutrix.akram.tlili.domain.errors.MultipleInstancesFound;
import com.neutrix.akram.tlili.domain.errors.NotEnoughCredit;
import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;

import java.time.LocalDate;

public class MainPresenter implements Contract.IMainPresenter{
    private AddClientUseCase  addClientUseCase;
    private AddStockItem addStockItem;
    private RentItem rentItem;
    private Contract.IMainView view;

    public MainPresenter(AddClientUseCase addClientUseCase,AddStockItem addStockItem,RentItem rentItem, Contract.IMainView view) {
        this.addClientUseCase = addClientUseCase;
        this.addStockItem = addStockItem;
        this.rentItem = rentItem;
        this.view = view;
    }

    @Override
    public void addClient(float balance, String name) {
        view.clearText();
        String result  =  addClientUseCase.execute(new Client(name,balance));
        view.showOperationResult(result);
    }

    @Override
    public void addStockItem(float rentalPrice, String title) {
        view.clearText();
        String result  =  addStockItem.execute(new StockItem(rentalPrice,title));
        view.showOperationResult(result);
    }

    @Override
    public void addMovie(float rentalPrice, String title, String actor) {

    }

    @Override
    public void showStockItemByTitle(String title) {

    }

    @Override
    public void showMovieByActor(String actor) {

    }

    @Override
    public void rentItem(String itemId, String clientId, LocalDate dueDate) {
        try {
            rentItem.execute(new RentedItem(dueDate,clientId,itemId));
            view.showOperationResult("Operation Succeded");
        } catch (NotEnoughCredit notEnoughCredit) {
            view.showOperationResult(notEnoughCredit.getLocalizedMessage());
        } catch (ItemNotFound itemNotFound) {
            view.showOperationResult(itemNotFound.getLocalizedMessage());
        } catch (MultipleInstancesFound multipleInstancesFound) {
            view.showOperationResult(multipleInstancesFound.getLocalizedMessage());
        }
    }

    @Override
    public void returnItem(String itemId, String clientId) {

    }

    @Override
    public void showRentedItemsByClient(String clientId) {

    }

    @Override
    public void showRentedItemsLateByClient(String clientId) {

    }

}
