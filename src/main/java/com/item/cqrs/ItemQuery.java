package com.item.cqrs;

import com.item.domain.Item;
import com.item.exception.ItemNotFoundException;
import com.item.repository.ItemRepository;

public class ItemQuery {

    private final ItemRepository itemRepository;

    public ItemQuery() {
        this.itemRepository = ItemRepository.INSTANCE;
    }

    public Item get(Long id) throws ItemNotFoundException {
        return itemRepository.get(id);
    }
}
