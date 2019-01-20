package com.gildedrose;

abstract class ItemStrategy {

    private static final int MAXIMUM_QUALITY = 50;

    abstract void updateItem(Item item);

    boolean isMaximumQuality(int quality) {
        return quality >= MAXIMUM_QUALITY;
    }
}
