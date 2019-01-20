package com.gildedrose;

import java.util.Arrays;

enum ItemType {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    GENERAL;

    private String fullName;

    ItemType() {
        this(null);
    }

    ItemType(String fullName) {
        this.fullName = fullName;
    }

    public static ItemType findByFullName(String fullName) {
        return Arrays.stream(ItemType.values())
                .filter(itemType -> itemType.getFullName() != null)
                .filter(itemType -> fullName.equals(itemType.getFullName()))
                .findFirst()
                .orElse(GENERAL);
    }

    public String getFullName() {
        return fullName;
    }
}
