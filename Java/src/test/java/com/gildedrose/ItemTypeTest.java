package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTypeTest {

    @Test
    public void findByFullName_shouldReturnCorrectItemType() {
        ItemType foundItemType = ItemType.findByFullName(
                ItemType.AGED_BRIE.getFullName()
        );

        assertThat(foundItemType).isEqualTo(ItemType.AGED_BRIE);
    }

    @Test
    public void findByFullName_shouldReturnGeneralItemType_whenFullNameIsNotMatchingAnyValue() {
        ItemType foundItemType = ItemType.findByFullName(
                "Non matching item type"
        );

        assertThat(foundItemType).isEqualTo(ItemType.GENERAL);
    }
}