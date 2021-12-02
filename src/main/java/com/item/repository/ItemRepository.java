package com.item.repository;

import com.item.domain.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    private final Map<Long, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
    }

    public void add(Item item) {
        items.put(item.getId(), item);
    }

    public Item get(Long id) {
        return items.get(id);
    }
}
