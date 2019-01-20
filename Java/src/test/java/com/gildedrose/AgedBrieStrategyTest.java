package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieStrategyTest {

    @Test
    public void updateItemAtEndOfDay_shouldLowerSellInOfAgedBrieByOne() {
        Item agedBrie = new Item(ItemType.AGED_BRIE.getFullName(), 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.sellIn).isEqualTo(19);
    }

    @Test
    public void updateItemAtEndOfDay_shouldLowerSellInOfAgedBrieToNegativeNumber_whenSellInEqualsZero() {
        Item agedBrie = new Item(ItemType.AGED_BRIE.getFullName(), 0, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.sellIn).isEqualTo(-1);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfAgedBrieByOne_whenQualityIsLowerThanFifty() {
        Item agedBrie = new Item(ItemType.AGED_BRIE.getFullName(), 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.quality).isEqualTo(41);
    }

    @Test
    public void updateItemAtEndOfDay_shouldNotIncreaseQualityOfAgedBrie_whenQualityEqualsFifty() {
        Item agedBrie = new Item(ItemType.AGED_BRIE.getFullName(), 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.quality).isEqualTo(50);
    }
}