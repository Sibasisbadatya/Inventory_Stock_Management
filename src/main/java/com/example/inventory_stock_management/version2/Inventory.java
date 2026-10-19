package com.example.inventory_stock_management.version2;

public class Inventory {
    private int stock = 100;

    public synchronized boolean buyProduct() throws InterruptedException {
        if (stock > 0) {
            Thread.sleep(1);
            stock--;
            return true;
        }
        return false;
    }

    public synchronized void addStock(int quantity) {
        stock += quantity;
    }

    public int getQuantity() {
        return stock;
    }
}
