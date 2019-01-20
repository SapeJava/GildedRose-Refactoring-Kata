package com.gildedrose;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;

import static com.gildedrose.ItemType.*;

class GildedRose {

    private static final Map<ItemType, ItemStrategy> ITEM_SPECIAL_STRATEGIES = ImmutableMap.of(
            AGED_BRIE, new AgedBrieStrategy(),
            BACKSTAGE_PASSES, new BackstagePassesStrategy(),
            SULFURAS, new SulfurasStrategy(),
            CONJURED, new ConjuredStrategy(),
            GENERAL, new GeneralStrategy()
    );

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItemAtEndOfDay() {
        Arrays.stream(items).forEach(item -> {
            ItemType itemType = findByFullName(item.name);
            ItemStrategy itemStrategy = ITEM_SPECIAL_STRATEGIES.get(itemType);

            itemStrategy.updateItem(item);
        });
    }
}