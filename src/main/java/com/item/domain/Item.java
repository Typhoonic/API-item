package com.item.domain;

public class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
