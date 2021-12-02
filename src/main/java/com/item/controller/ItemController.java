package com.item.controller;

import com.item.cqrs.ItemCommand;
import com.item.cqrs.ItemQuery;
import com.item.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    private final ItemCommand commandController;
    private final ItemQuery queryController;

    public ItemController() {
        commandController = new ItemCommand();
        queryController = new ItemQuery();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Long id) {
        return queryController.get(id);
    }

    @PutMapping()
    public void add(@RequestBody Item item) {
        commandController.add(item);
    }
}
