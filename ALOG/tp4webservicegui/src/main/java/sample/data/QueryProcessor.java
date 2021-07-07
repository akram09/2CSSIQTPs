package sample.data;



import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import sample.domain.models.Client;
import sample.domain.models.StockItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient client;

    public QueryProcessor(OkHttpClient client) {
        this.client = client;
    }

    public List<Client> fetchClientsByID(String clientId){
        /*
        try{

            String FETCH_CLIENT_BY_ID = "SELECT * FROM CLIENT WHERE id = ? ";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(FETCH_CLIENT_BY_ID);
            statement.setString(1,clientId);
            ResultSet rs = statement.executeQuery();
            List<Client> clients = new ArrayList<>();
            while(rs.next()){
                clients.add(new Client( rs.getString(1), rs.getString(2),rs.getFloat(3)));
            }
            System.out.println(clients);
            return clients;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }*/
        return null;
    }
    public List<StockItem> fetchItemByID(String itemId){
        /*
        try{
            String FETCH_STOCK_ITEM_BY_ID = "SELECT * FROM STOCK_ITEM WHERE id = ? ";
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(FETCH_STOCK_ITEM_BY_ID);
            statement.setString(1,itemId);
            ResultSet rs = statement.executeQuery();
            List<StockItem> items = new ArrayList<>();
            while(rs.next()){
                items.add(new StockItem( rs.getFloat(3), rs.getString(2),rs.getString(1)));
            }
            System.out.println(items);
            return items;
        }catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }*/
        return null;
    }

}
