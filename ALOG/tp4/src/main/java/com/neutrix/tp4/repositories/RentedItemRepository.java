package com.neutrix.tp4.repositories;

import com.neutrix.tp4.models.RentedItem;
import org.springframework.data.repository.CrudRepository;

public interface RentedItemRepository extends CrudRepository<RentedItem, String> {
}
