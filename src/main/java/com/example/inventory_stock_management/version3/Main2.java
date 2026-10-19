package com.example.inventory_stock_management.version3;


public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        SharedInventory inventory1 = new SharedInventory();
        SharedInventory inventory2 = new SharedInventory();
        Thread[] consumers = new Thread[100];

        for (int i = 0; i < 100; i++) {
            final int customerId = i + 1;
            consumers[i] = new Thread(() -> {
                boolean purchased = false;
                if (customerId % 2 == 0)
                    purchased = inventory1.buyProduct();
                else
                    purchased = inventory2.buyProduct();
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
                "Final stock:1 " + inventory1.getStock()
        );
        System.out.println(
                "Final stock:2 " + inventory2.getStock()
        );
    }
}
