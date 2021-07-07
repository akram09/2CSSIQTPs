package com.neutrix.tp4.repositories;

import com.neutrix.tp4.models.StockItem;
import org.springframework.data.repository.CrudRepository;

public interface StockItemRepository extends CrudRepository<StockItem, String> {

}
