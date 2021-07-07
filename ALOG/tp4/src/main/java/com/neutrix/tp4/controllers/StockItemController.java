package com.neutrix.tp4.controllers;

import com.neutrix.tp4.Tp4Application;
import com.neutrix.tp4.models.Client;
import com.neutrix.tp4.models.StockItem;
import com.neutrix.tp4.repositories.ClientRepository;
import com.neutrix.tp4.repositories.StockItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StockItemController {
    @Autowired
    StockItemRepository itemRepository;

    private static final Logger log = LoggerFactory.getLogger(Tp4Application.class);
    @PostMapping("/stockItems")
    public ResponseEntity<StockItem> createStockItem(@RequestBody StockItem item){
        try{
            log.debug(item.toString());
            StockItem _item = itemRepository.save(new StockItem(item.getRentalPrice(), item.getTitle()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/stockItems/{id}")
    public ResponseEntity<StockItem> getStockItemById(@PathVariable("id") String id) {
        Optional<StockItem> stockOptional = itemRepository.findById(id);
        return stockOptional.map(stockItem -> new ResponseEntity<>(stockItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
