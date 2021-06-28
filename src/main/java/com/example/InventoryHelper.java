package com.example;

public class InventoryHelper {

    public int getUsableCapacity(Inventory inventory) {
        return inventory.getCapacity() - inventory.getCurrent();
    }

    public boolean inbound(Inventory inventory, int count) {
        if(this.getInboundable(inventory, count)) {
            inventory.setCurrent(count);
            return true;
        }
        return false;
    }

    public boolean getInboundable(Inventory inventory, int count) {
        return getUsableCapacity(inventory) >= count;
    }

    public Inventory getCreateInventory() {
        return new Inventory();
    }
}
