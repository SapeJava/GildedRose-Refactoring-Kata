package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralStrategyTest {

    private static final String GENERAL_ITEM = "General Test Item";

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseSellInOfGeneralItemByOne() {
        Item generalItem = new Item(GENERAL_ITEM, 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {generalItem});

        gildedRose.updateItemAtEndOfDay();

        assertThat(generalItem.sellIn).isEqualTo(19);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfGeneralItemByOne() {
        Item generalItem = new Item(GENERAL_ITEM, 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {generalItem});

        gildedRose.updateItemAtEndOfDay();

        assertThat(generalItem.quality).isEqualTo(39);
    }

    @Test
    public void updateItemAtEndOfDay_shouldNotDecreaseQualityOfGeneralItem_whenQualityEqualsZero() {
        Item generalItem = new Item(GENERAL_ITEM, 20, 0);
        GildedRose gildedRose = new GildedRose(new Item[] {generalItem});

        gildedRose.updateItemAtEndOfDay();

        assertThat(generalItem.quality).isEqualTo(0);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfGeneralItemByTwo_whenSellInEqualsZero() {
        Item generalItem = new Item(GENERAL_ITEM, 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {generalItem});

        gildedRose.updateItemAtEndOfDay();

        assertThat(generalItem.quality).isEqualTo(38);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfGeneralItemByTwo_whenSellInDecreaseThanZero() {
        Item generalItem = new Item(GENERAL_ITEM, -2, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {generalItem});

        gildedRose.updateItemAtEndOfDay();

        assertThat(generalItem.quality).isEqualTo(38);
    }
}