package com.neutrix.tp4.repositories;

import com.neutrix.tp4.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String > {
    Client findByCustomerId(String customerId);
}
