package sample.data;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sample.domain.models.Client;
import sample.domain.models.RentedItem;
import sample.domain.models.StockItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static sample.data.QueryProcessor.JSON;
import static sample.data.Utils.URL;

public class TransactionProcessor {
    private OkHttpClient httpClient;
    private Gson gson;

    public TransactionProcessor(OkHttpClient client, Gson gson) {
        this.gson = gson;
        this.httpClient = client;
    }

    public Client createClient(Client client){
        String json = gson.toJson(client);
        RequestBody body = RequestBody.create( json, JSON);
        Request request = new Request.Builder()
                .url("http://localhost:8080/clients")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response);
            return gson.fromJson(response.body().string(),Client.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
    public StockItem createStockItem(StockItem item){
        String json = gson.toJson(item);
        RequestBody body = RequestBody.create( json, JSON);
        Request request = new Request.Builder()
                .url("http://localhost:8080/stockItems")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response);
            return gson.fromJson(response.body().string(),StockItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }
    public RentedItem createRentedItem(RentedItem item){
        return item;
    }


    public Client updateClient(Client client){
        return client;
    }
    public String rentItem(RentedItem rentItem){
        String json = gson.toJson(rentItem);
        System.out.println(json);
        RequestBody body = RequestBody.create( json, JSON);

        Request request = new Request.Builder()
                .url(URL +"renteditems")
                .post(body)
                .build();
        System.out.println(request.body());
        System.out.println(request.headers());
        try (Response response = httpClient.newCall(request).execute()) {
            if(response.code() ==500){
                return null;
            }else{
                System.out.println(response);
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rentItem.toString();
    }

}
