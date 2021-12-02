package com.item.controller;

import com.item.domain.Item;
import com.item.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController() {
        itemRepository = new ItemRepository();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Long id) {
        return itemRepository.get(id);
    }

    @PutMapping()
    public void add(@RequestBody Item item) {
        itemRepository.add(item);
    }
}
