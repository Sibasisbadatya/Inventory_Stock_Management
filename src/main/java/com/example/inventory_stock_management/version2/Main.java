package com.example.inventory_stock_management.version2;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        Thread[] consumers = new Thread[100];

        for (int i = 0; i < 100; i++) {
            final int customerId = i + 1;
            consumers[i] = new Thread(() -> {
                boolean purchased = false;
                try {
                    purchased = inventory.buyProduct();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (purchased) {
                    System.out.println("Customer" + customerId + "purchased succesfully");
                } else {
                    System.out.println("Customer" + customerId + ": out of stock");
                }
            });

        }

        for (Thread consumer : consumers) {
            consumer.start();
        }


        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println(
                "Final stock: " + inventory.getQuantity()
        );

    }
}
