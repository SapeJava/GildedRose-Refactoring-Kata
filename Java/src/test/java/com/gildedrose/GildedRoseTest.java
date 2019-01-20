package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private static final String GENERAL_ITEM = "General Test Item";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    //General item

    @Test
    public void updateQuality_shouldLowerSellInOfGeneralItemByOne() {
        Item[] items = new Item[]{
                new Item(GENERAL_ITEM, 20, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, 19);
    }

    @Test
    public void updateQuality_shouldLowerQualityOfGeneralItemByOne() {
        Item[] items = new Item[]{
                new Item(GENERAL_ITEM, 20, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 39);
    }

    @Test
    public void updateQuality_shouldNotLowerQualityOfGeneralItem_whenQualityEqualsZero() {
        Item[] items = new Item[]{
                new Item(GENERAL_ITEM, 20, 0),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 0);
    }

    @Test
    public void updateQuality_shouldLowerQualityOfAgedBrieByTwo_whenSellInEqualsZero() {
        Item[] items = new Item[]{
                new Item(GENERAL_ITEM, 0, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 38);
    }

    @Test
    public void updateQuality_shouldLowerQualityOfAgedBrieByTwo_whenSellInLowerThanZero() {
        Item[] items = new Item[]{
                new Item(GENERAL_ITEM, -2, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 38);
    }

    //Aged brie

    @Test
    public void updateQuality_shouldLowerSellInOfAgedBrieByOne() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 20, 50),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, 19);
    }

    @Test
    public void updateQuality_shouldLowerSellInOfAgedBrieToNegativeNumber_whenSellInEqualsZero() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 0, 50),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, -1);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrieByOne_whenQualityIsLowerThanFifty() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 20, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 41);
    }

    @Test
    public void updateQuality_shouldNotIncreaseQualityOfAgedBrie_whenQualityEqualsFifty() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 20, 50),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 50);
    }

    //Backstage passes

    @Test
    public void updateQuality_shouldLowerSellInOfBackstagePassesByOne() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 20, 50),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, 19);
    }

    @Test
    public void updateQuality_shouldLowerSellInOfBackstagePassesToNegativeNumber_whenSellInEqualsZero() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 0, 50),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, -1);
    }


    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInEqualsTen() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 10, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 42);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByTwo_whenSellInBetweenTenAndFive() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 7, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 42);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInEqualsFive() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 5, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 43);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfBackstagePassesByThree_whenSellInBetweenFiveAndZero() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 3, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 43);
    }

    @Test
    public void updateQuality_shouldLowerQualityOfBackstagePassesToZero_whenSellInEqualsZero() {
        Item[] items = new Item[]{
                new Item(BACKSTAGE_PASSES, 0, 40),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 0);
    }

    //Sulfuras

    @Test
    public void updateQuality_shouldNotLowerOrIncreaseSellInOfSulfuras() {
        Item[] items = new Item[]{
                new Item(SULFURAS, 20, 80),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].sellIn, 20);
    }

    @Test
    public void updateQuality_shouldNotLowerOrIncreaseQualityOfSulfuras() {
        Item[] items = new Item[]{
                new Item(SULFURAS, 20, 80),
        };
        GildedRose app = new GildedRose(items);

        app.updateItemAtEndOfDay();

        assertEquals(app.items[0].quality, 80);
    }
}
