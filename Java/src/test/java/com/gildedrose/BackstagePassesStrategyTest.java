package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassesStrategyTest {

    @Test
    public void updateItemAtEndOfDay_shouldLowerSellInOfBackstagePassesByOne() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 20, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.sellIn).isEqualTo(19);
    }

    @Test
    public void updateItemAtEndOfDay_shouldLowerSellInOfBackstagePassesToNegativeNumber_whenSellInEqualsZero() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 0, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.sellIn).isEqualTo(-1);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfBackstagePassesByOne_whenSellInHigherThanTen() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 11, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(41);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInEqualsTen() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(42);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInBetweenTenAndFive() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 7, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(42);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInEqualsFive() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 5, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(43);
    }

    @Test
    public void updateItemAtEndOfDay_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInBetweenFiveAndZero() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 3, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(43);
    }

    @Test
    public void updateItemAtEndOfDay_shouldLowerQualityOfBackstagePassesToZero_whenSellInEqualsZero() {
        Item backstagePasses = new Item(ItemType.BACKSTAGE_PASSES.getFullName(), 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

        gildedRose.updateItemAtEndOfDay();

        assertThat(backstagePasses.quality).isEqualTo(0);
    }
}