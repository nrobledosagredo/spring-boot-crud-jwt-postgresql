package com.nrobledosagredo.itemmanagement.service;

import org.springframework.stereotype.Service;

import com.nrobledosagredo.itemmanagement.model.Item;
import com.nrobledosagredo.itemmanagement.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

// Handles business logic for Item operations
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Create new item associated with a user
    public Item createItem(Item item, String userId) {
        item.setUserId(userId);
        return itemRepository.save(item);
    }

    // Get all items for a specific user
    public List<Item> getAllItems(String userId) {
        return itemRepository.findByUserId(userId);
    }

    // Find item by ID (only if it belongs to the user)
    public Optional<Item> getItemById(Long id, String userId) {
        return itemRepository.findById(id)
                .filter(item -> item.getUserId().equals(userId));
    }

    // Update item (only if it belongs to the user)
    public Optional<Item> updateItem(Long id, Item updatedItem, String userId) {
        return itemRepository.findById(id)
                .filter(item -> item.getUserId().equals(userId))
                .map(item -> {
                    item.setName(updatedItem.getName());
                    return itemRepository.save(item);
                });
    }

    // Delete item (only if it belongs to the user)
    public boolean deleteItem(Long id, String userId) {
        return itemRepository.findById(id)
                .filter(item -> item.getUserId().equals(userId))
                .map(item -> {
                    itemRepository.delete(item);
                    return true;
                }).orElse(false);
    }
}
