package com.item.cqrs;

import com.item.domain.Item;
import com.item.repository.ItemRepository;

public class ItemCommand {

    private final ItemRepository itemRepository;

    public ItemCommand() {
        this.itemRepository = ItemRepository.INSTANCE;
    }

    public void add(Item item) {
        itemRepository.add(item);
    }
}
