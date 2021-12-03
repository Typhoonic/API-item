package com.item.cqrs;

import com.item.domain.Item;
import com.item.repository.ItemRepository;

public class ItemQuery {

    private final ItemRepository itemRepository;

    public ItemQuery() {
        this.itemRepository = ItemRepository.INSTANCE;
    }

    public Item get(Long id) throws Exception {
        return itemRepository.get(id);
    }
}
