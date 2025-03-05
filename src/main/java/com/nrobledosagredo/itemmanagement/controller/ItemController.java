package com.nrobledosagredo.itemmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nrobledosagredo.itemmanagement.model.Item;
import com.nrobledosagredo.itemmanagement.service.ItemService;

import java.security.Principal;
import java.util.List;

// Handles item-related HTTP requests at /items
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Create new item (user-specific)
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item, Principal principal) {
        String userId = principal.getName();
        return ResponseEntity.ok(itemService.createItem(item, userId));
    }

    // Get all items for the authenticated user
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(Principal principal) {
        String userId = principal.getName();
        return ResponseEntity.ok(itemService.getAllItems(userId));
    }

    // Get an item by ID (only if it belongs to the user)
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id, Principal principal) {
        String userId = principal.getName();
        return itemService.getItemById(id, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an item (only if it belongs to the user)
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(
            @PathVariable Long id,
            @RequestBody Item updatedItem,
            Principal principal) {
        String userId = principal.getName();
        return itemService.updateItem(id, updatedItem, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete an item (only if it belongs to the user)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id, Principal principal) {
        String userId = principal.getName();
        return itemService.deleteItem(id, userId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
