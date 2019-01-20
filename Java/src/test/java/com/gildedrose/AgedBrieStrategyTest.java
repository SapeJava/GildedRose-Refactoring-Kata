package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieStrategyTest {

    private static final String AGED_BRIE = "Aged Brie";

    @Test
    public void updateQuality_shouldLowerSellInOfAgedBrieByOne() {
        Item agedBrie = new Item(AGED_BRIE, 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.sellIn).isEqualTo(19);
    }

    @Test
    public void updateQuality_shouldLowerSellInOfAgedBrieToNegativeNumber_whenSellInEqualsZero() {
        Item agedBrie = new Item(AGED_BRIE, 0, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.sellIn).isEqualTo(-1);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrieByOne_whenQualityIsLowerThanFifty() {
        Item agedBrie = new Item(AGED_BRIE, 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.quality).isEqualTo(41);
    }

    @Test
    public void updateQuality_shouldNotIncreaseQualityOfAgedBrie_whenQualityEqualsFifty() {
        Item agedBrie = new Item(AGED_BRIE, 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

        gildedRose.updateItemAtEndOfDay();

        assertThat(agedBrie.quality).isEqualTo(50);
    }
}