package com.item.repository;

import com.item.domain.Item;

import java.util.HashMap;
import java.util.Map;

public enum ItemRepository {

    INSTANCE;

    private final Map<Long, Item> items = new HashMap<>();

    public void add(Item item) {
        items.put(item.getId(), item);
    }

    public Item get(Long id) throws Exception {

        if(items.containsKey(id))
        return items.get(id);

        throw new Exception();
    }

    public int size() {
        return items.size();
    }
}
