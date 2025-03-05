package com.nrobledosagredo.itemmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nrobledosagredo.itemmanagement.model.Item;

import java.util.List;

// Spring Data JPA repository for Items
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  // Get all items that belong to a specific user
  List<Item> findByUserId(String userId);
}