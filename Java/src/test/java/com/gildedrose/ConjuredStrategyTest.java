package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredStrategyTest {

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseSellInOfConjuredItemByOne() {
        Item conjured = new Item(ItemType.CONJURED.getFullName(), 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});

        gildedRose.updateItemAtEndOfDay();

        assertThat(conjured.sellIn).isEqualTo(19);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfConjuredItemByTwo() {
        Item conjured = new Item(ItemType.CONJURED.getFullName(), 20, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});

        gildedRose.updateItemAtEndOfDay();

        assertThat(conjured.quality).isEqualTo(38);
    }

    @Test
    public void updateItemAtEndOfDay_shouldNotDecreaseQualityOfConjuredItem_whenQualityEqualsZero() {
        Item conjured = new Item(ItemType.CONJURED.getFullName(), 20, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});

        gildedRose.updateItemAtEndOfDay();

        assertThat(conjured.quality).isEqualTo(0);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfConjuredItemByFour_whenSellInEqualsZero() {
        Item conjured = new Item(ItemType.CONJURED.getFullName(), 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});

        gildedRose.updateItemAtEndOfDay();

        assertThat(conjured.quality).isEqualTo(36);
    }

    @Test
    public void updateItemAtEndOfDay_shouldDecreaseQualityOfConjuredItemByFour_whenSellInDecreaseThanZero() {
        Item conjured = new Item(ItemType.CONJURED.getFullName(), -2, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});

        gildedRose.updateItemAtEndOfDay();

        assertThat(conjured.quality).isEqualTo(36);
    }
}