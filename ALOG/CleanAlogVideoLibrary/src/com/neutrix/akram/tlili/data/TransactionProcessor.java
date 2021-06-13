package com.neutrix.akram.tlili.data;

import com.neutrix.akram.tlili.domain.models.Client;
import com.neutrix.akram.tlili.domain.models.RentedItem;
import com.neutrix.akram.tlili.domain.models.StockItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionProcessor {
    private Database database;

    public TransactionProcessor(Database database) {
        this.database = database;
    }
    public Client createClient(Client client){
        try {
            String ADD_CLIENT_STATEMENT = "INSERT INTO CLIENT (id , name , balance)  VALUES(? , ? , ?)";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_CLIENT_STATEMENT);
            statement.setString(1,client.getCustomerId());
            statement.setString(2, client.getName());
            statement.setFloat(3,client.getAccountBalance());
            int res = statement.executeUpdate();
            System.out.println("Result of operation "+res);
            return client;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return client;
    }
    public StockItem createStockItem(StockItem item){
        try {
            String ADD_STOCK_ITEM = "INSERT INTO STOCK_ITEM (id , title , rentPrice)  VALUES(? , ? , ?)";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_STOCK_ITEM);
            statement.setString(1,item.getItemId());
            statement.setString(2, item.getTitle());
            statement.setFloat(3,item.getRentalPrice());
            int res = statement.executeUpdate();
            System.out.println("Result of operation "+res);
            return item;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return item;
    }
    public RentedItem createRentedItem(RentedItem item){
        try {
            String ADD_STOCK_ITEM = "INSERT INTO RENTED_ITEM (id , itemId, clientId , dueDate)  VALUES(? , ? , ?, ?)";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_STOCK_ITEM);
            statement.setString(1,item.getRentedItemId());
            statement.setString(2,item.getItemId());
            statement.setString(3, item.getClientId());
            statement.setString(4,item.getDueDate().toString());
            int res = statement.executeUpdate();
            System.out.println("Result of operation "+res);
            return item;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return item;
    }


    public Client updateClient(Client client){
        try {
            String UPDATE_CLIENT_STATEMENT = "UPDATE CLIENT SET name=?, balance=? WHERE id=?";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_STATEMENT);
            statement.setString(1, client.getName());
            statement.setFloat(2,client.getAccountBalance());
            statement.setString(3,client.getCustomerId());
            int res = statement.executeUpdate();
            System.out.println("Result of operation "+res);
            return client;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return client;
    }

}
