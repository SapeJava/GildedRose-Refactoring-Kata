package com.gildedrose;

public class BackstagePassesStrategy extends ItemStrategy {

    private static final int QUALITY_INCREASE_OF_TWO = 2;
    private static final int QUALITY_INCREASE_OF_THREE = 3;
    private static final int QUALITY_BOTTOM = 0;

    private static final int QUALITY_INCREASE_OF_TWO_BOUNDARY = 10;
    private static final int QUALITY_INCREASE_OF_THREE_BOUNDARY = 5;
    private static final int QUALITY_DECREASE_TO_ZERO_BOUNDARY = 0;

    @Override
    public void updateItem(Item item) {
        if (!isMaximumQuality(item.quality)) {
            increaseQuality(item);
        }

        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        int sellIn = item.sellIn;

        if (qualityShouldIncreaseByOne(sellIn)) {
            item.quality++;
        } else if (qualityShouldIncreaseByTwo(sellIn)) {
            item.quality += QUALITY_INCREASE_OF_TWO;
        } else if (qualityShouldIncreateByThree(sellIn)) {
            item.quality += QUALITY_INCREASE_OF_THREE;
        } else if (sellInIsPassed(sellIn)) {
            item.quality = QUALITY_BOTTOM;
        }
    }

    private boolean qualityShouldIncreaseByOne(int sellIn) {
        return sellIn > QUALITY_INCREASE_OF_TWO_BOUNDARY;
    }

    private boolean qualityShouldIncreaseByTwo(int sellIn) {
        return sellIn <= QUALITY_INCREASE_OF_TWO_BOUNDARY &&
                sellIn > QUALITY_INCREASE_OF_THREE_BOUNDARY;
    }

    private boolean qualityShouldIncreateByThree(int sellIn) {
        return sellIn <= QUALITY_INCREASE_OF_THREE_BOUNDARY && !sellInIsPassed(sellIn);
    }

    private boolean sellInIsPassed(int sellIn) {
        return sellIn <= QUALITY_DECREASE_TO_ZERO_BOUNDARY;
    }
}
