package sample.presentation;

import java.time.LocalDate;

public interface Contract {

    interface IMainPresenter{
        void addClient(float balance, String name);
        void addStockItem(float rentalPrice, String title);
        void addMovie(float rentalPrice, String title, String actor);
        void showStockItemByTitle(String title);
        void showMovieByActor(String actor);
        void rentItem(String itemId, String clientId, LocalDate dueDate);
        void returnItem(String itemId, String clientId);
        void showRentedItemsByClient(String clientId);
        void showRentedItemsLateByClient(String clientId);
    }

    interface IMainView{
        void showOperationResult(String operationResult);
        void clearText();
    }
}
