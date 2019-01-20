package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasStrategyTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    public void updateQuality_shouldNotLowerOrIncreaseSellInOfSulfuras() {
        Item sulfuras = new Item(SULFURAS, 20, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateItemAtEndOfDay();

        assertThat(sulfuras.sellIn).isEqualTo(20);
    }

    @Test
    public void updateQuality_shouldNotLowerOrIncreaseQualityOfSulfuras() {
        Item sulfuras = new Item(SULFURAS, 20, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateItemAtEndOfDay();

        assertThat(sulfuras.quality).isEqualTo(80);
    }
}