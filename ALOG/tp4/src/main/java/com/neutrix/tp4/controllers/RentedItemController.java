package com.neutrix.tp4.controllers;

import com.neutrix.tp4.Tp4Application;
import com.neutrix.tp4.models.Client;
import com.neutrix.tp4.models.RentedItem;
import com.neutrix.tp4.models.StockItem;
import com.neutrix.tp4.repositories.ClientRepository;
import com.neutrix.tp4.repositories.RentedItemRepository;
import com.neutrix.tp4.repositories.StockItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class RentedItemController {
    @Autowired
    RentedItemRepository rentedItemRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StockItemRepository itemRepository;


    private static final Logger log = LoggerFactory.getLogger(Tp4Application.class);


    @PostMapping("/renteditems")
    public ResponseEntity<RentedItem> createRentedItem(@RequestBody RentedItem rentedItem){
        try{
            log.debug(rentedItem.toString());

            Optional<Client> _client = clientRepository.findById(rentedItem.getClientId());
            Optional<StockItem> _stockItem = itemRepository.findById(rentedItem.getItemId());
            if(_client.isPresent() && _stockItem.isPresent()){
                if(_client.get().getAccountBalance()< _stockItem.get().getRentalPrice()){
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }else{
                    _client.get().setAccountBalance(_client.get().getAccountBalance()-_stockItem.get().getRentalPrice());
                    clientRepository.save(_client.get());
                    RentedItem _rentedItem = rentedItemRepository.save(new RentedItem(rentedItem.getDueDate(), rentedItem.getClientId(), rentedItem.getItemId()));
                    return new ResponseEntity<>(_rentedItem, HttpStatus.CREATED);
                }
            }else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
