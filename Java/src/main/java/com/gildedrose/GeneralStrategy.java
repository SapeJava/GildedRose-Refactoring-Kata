package com.gildedrose;

class GeneralStrategy extends ItemStrategy {

    private static final int QUALITY_DECREASE_OF_TWO = 2;
    private static final int QUALITY_DECREASE_BY_TWO_BOUNDARY = 0;
    private static final int QUALITY_BOTTOM = 0;

    @Override
    void updateItem(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (qualityShouldBeLoweredByTwo(sellIn, quality)) {
            item.quality -= QUALITY_DECREASE_OF_TWO;
        } else if (qualityShouldBeLoweredByOne(sellIn, quality)) {
            item.quality--;
        }

        item.sellIn--;
    }

    private boolean qualityShouldBeLoweredByTwo(int sellIn, int quality) {
        int newQuality = quality - QUALITY_DECREASE_OF_TWO;

        return sellIn <= QUALITY_DECREASE_BY_TWO_BOUNDARY && newQuality >= QUALITY_BOTTOM;
    }

    private boolean qualityShouldBeLoweredByOne(int sellIn, int quality) {
        int newQuality = --quality;

        return sellIn > QUALITY_DECREASE_BY_TWO_BOUNDARY && newQuality >= QUALITY_BOTTOM;
    }
}
