package com.gildedrose;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final Map<String, ItemStrategy> ITEM_SPECIAL_STRATEGIES = ImmutableMap.of(
            AGED_BRIE, new AgedBrieStrategy(),
            BACKSTAGE_PASSES, new BackstagePassesStrategy(),
            SULFURAS, new SulfurasStrategy()
    );
    private static final GeneralItemStrategy GENERAL_ITEM_STRATEGY = new GeneralItemStrategy();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItemAtEndOfDay() {
        Arrays.stream(items).forEach(item -> {
            ItemStrategy itemStrategy = ITEM_SPECIAL_STRATEGIES.getOrDefault(item.name, GENERAL_ITEM_STRATEGY);
            itemStrategy.updateItem(item);
        });
    }
}