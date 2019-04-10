package com.example.async;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-09 23:49
 **/
public class SyncExample {

    private static class Maicai extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ShaoShui extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Zuofan extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Maicai maicai = new Maicai();
        ShaoShui shaoShui = new ShaoShui();
        Zuofan zuofan = new Zuofan();
        maicai.start();
        maicai.join();
        shaoShui.start();
        shaoShui.join();
        zuofan.start();
        zuofan.join();
        System.out.println("Total time is " + (System.currentTimeMillis() - startTime) % 1000 + "s.");
    }

}
