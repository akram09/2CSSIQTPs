package com.neutrix.tp4.controllers;


import com.neutrix.tp4.Tp4Application;
import com.neutrix.tp4.models.Client;
import com.neutrix.tp4.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;


    private static final Logger log = LoggerFactory.getLogger(Tp4Application.class);

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        try{
            log.debug(client.toString());
            Client _client = clientRepository.save(new Client(client.getName(), client.getAccountBalance()));
            return new ResponseEntity<>(_client,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        return clientOptional.map(client -> new ResponseEntity<>(client, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
