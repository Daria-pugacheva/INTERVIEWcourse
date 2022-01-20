package ru.gb.pugacheva.homework_3;

public class PingPongMainApp {
    private final Object monitor = new Object();
    private String currentVariant = "Ping";

    public void ping() {
        synchronized (monitor) {
            try {
                while (true) {
                    while (currentVariant != "Ping") {
                        monitor.wait();
                    }
                    System.out.println("Ping");
                    currentVariant = "Pong";
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pong() {
        synchronized (monitor) {
            try {
                while (currentVariant != "Pong") {
                    monitor.wait();
                }
                System.out.println("Pong");
                currentVariant = "Ping";
                monitor.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PingPongMainApp pingPongMainApp = new PingPongMainApp();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pingPongMainApp.ping();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pingPongMainApp.pong();
                }
            }).start();
        }
    }


}
