package com.example.inventory_stock_management.version1;

public class Inventory {
    private int stock = 100;

    public boolean buyProduct() throws InterruptedException {
        if (stock > 0) {
            Thread.sleep(1);
            stock--;
            return true;
        }
        return false;
    }

    public void addStock(int quantity) {
        stock += quantity;
    }

    public int getQuantity() {
        return stock;
    }
}
