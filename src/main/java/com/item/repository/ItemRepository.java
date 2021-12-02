package com.item.repository;

import com.item.domain.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    public ItemRepository() {
    }

    private Map<Long, Item> items = new HashMap<>();

    public void add(Long id, Item item){
        items.put(id, item);
    }

    public String get(Long id){
        return items.get(id).getName();
    }
}
