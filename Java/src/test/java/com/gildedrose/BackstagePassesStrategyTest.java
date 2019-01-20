package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassesStrategyTest {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void updateQuality_shouldLowerSellInOfBackstagePassesByOne() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.sellIn).isEqualTo(19);
    }

    @Test
    public void updateQuality_shouldLowerSellInOfBackstagePassesToNegativeNumber_whenSellInEqualsZero() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 0, 50);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.sellIn).isEqualTo(-1);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByOne_whenSellInHigherThanTen() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 11, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(41);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInEqualsTen() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(42);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInBetweenTenAndFive() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 7, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(42);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInEqualsFive() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 5, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(43);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInBetweenFiveAndZero() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 3, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(43);
    }

    @Test
    public void updateQuality_shouldLowerQualityOfBackstagePassesToZero_whenSellInEqualsZero() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES, 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[] {backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(0);
    }
}