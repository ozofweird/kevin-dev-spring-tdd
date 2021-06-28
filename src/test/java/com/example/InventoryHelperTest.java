package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryHelperTest {

    @Test
    void testInventoryHelper_getUsableCapacity() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(10);
        inventory.setCapacity(5);

        int usableCapacity = inventoryHelper.getUsableCapacity(inventory);

        Assertions.assertEquals(5, usableCapacity);
    }

    @Test
    void testInventoryHelper_inbound_true() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        inventory.setCapacity(40);

        inventoryHelper.inbound(inventory, 10);
        Assertions.assertTrue(inventoryHelper.inbound(inventory, 10));
        Assertions.assertEquals(10, inventory.getCurrent());
    }

    @Test
    void testInventoryHelper_inbound_false() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        inventory.setCapacity(10);

        Assertions.assertFalse(inventoryHelper.inbound(inventory, 30));
        Assertions.assertEquals(0, inventory.getCurrent());
    }

    @Test
    void testInventoryHelper_inboundable_true() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        inventory.setCapacity(10);
        inventory.setCurrent(5);

        Assertions.assertTrue(inventoryHelper.getInboundable(inventory, 3));
    }

    @Test
    void testInventoryHelper_inboundable_false() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        inventory.setCapacity(10);
        inventory.setCurrent(5);

        Assertions.assertFalse(inventoryHelper.getInboundable(inventory, 10));
    }

    @Test
    void testInventoryHelper_createInventory() {
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = inventoryHelper.getCreateInventory();

        Assertions.assertTrue(inventory instanceof Inventory);
    }
}
