package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasStrategyTest {

    @Test
    public void updateItemAtEndOfDay_shouldNotLowerOrIncreaseSellInOfSulfuras() {
        Item sulfuras = new Item(ItemType.SULFURAS.getFullName(), 20, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateItemAtEndOfDay();

        assertThat(sulfuras.sellIn).isEqualTo(20);
    }

    @Test
    public void updateItemAtEndOfDay_shouldNotLowerOrIncreaseQualityOfSulfuras() {
        Item sulfuras = new Item(ItemType.SULFURAS.getFullName(), 20, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateItemAtEndOfDay();

        assertThat(sulfuras.quality).isEqualTo(80);
    }
}