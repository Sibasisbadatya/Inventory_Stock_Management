package com.example.inventory_stock_management.version3;

public class SharedInventory {
    private static int stock = 100;


//    public synchronized void instanceMethod() {
//        // Locks this
//    }
//
//    public static synchronized void staticMethod() {
//        // Locks Inventory.class
//    }

    public static synchronized boolean buyProduct() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }
//    equivalent to

//    public static void updateSomething() {
//        synchronized (SharedInventory.class) {
//            // Protected by Inventory.class
//        }
//    }

    public static synchronized void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    public static synchronized int getStock() {
        return stock;
    }
}
