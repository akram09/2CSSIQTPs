package com.neutrix.akram.tlili.presentation;

import java.time.LocalDate;

public class MainPresenter implements Contract.IMainPresenter{


    public MainPresenter() {
    }

    @Override
    public void addClient(float balance, String name) {

    }

    @Override
    public void addStockItem(float rentalPrice, String title) {

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
