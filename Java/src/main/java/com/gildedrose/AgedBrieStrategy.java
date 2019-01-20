package com.gildedrose;

public class AgedBrieStrategy extends ItemStrategy {

    @Override
    public void updateItem(Item item) {
        if (!isMaximumQuality(item.quality)) {
            item.quality++;
        }

        item.sellIn--;
    }
}
