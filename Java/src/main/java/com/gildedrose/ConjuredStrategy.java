package com.gildedrose;

class ConjuredStrategy extends ItemStrategy {

    private static final int QUALITY_DECREASE_OF_TWO = 2;
    private static final int QUALITY_DECREASE_OF_FOUR = 4;
    private static final int QUALITY_DECREASE_BY_FOUR_BOUNDARY = 0;
    private static final int QUALITY_BOTTOM = 0;

    @Override
    void updateItem(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (qualityShouldBeDecreasedByFour(sellIn, quality)) {
            item.quality -= QUALITY_DECREASE_OF_FOUR;
        } else if (qualityShouldBeDecreasedByTwo(sellIn, quality)) {
            item.quality -= QUALITY_DECREASE_OF_TWO;
        }

        item.sellIn--;
    }

    private boolean qualityShouldBeDecreasedByFour(int sellIn, int quality) {
        int newQuality = quality - QUALITY_DECREASE_OF_FOUR;

        return sellIn <= QUALITY_DECREASE_BY_FOUR_BOUNDARY && newQuality >= QUALITY_BOTTOM;
    }

    private boolean qualityShouldBeDecreasedByTwo(int sellIn, int quality) {
        int newQuality = quality - QUALITY_DECREASE_OF_TWO;

        return sellIn > QUALITY_DECREASE_BY_FOUR_BOUNDARY && newQuality >= QUALITY_BOTTOM;
    }
}
