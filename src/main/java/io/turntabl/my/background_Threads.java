package io.turntabl.my;

public class background_Threads {
   public static void main(String[]args) throws InterruptedException {

       Thread t = new Thread (() ->
               System.out.println("thread bill"));
       Thread t2 = new Thread (()->
               System.out.println("thread 2"));
       Thread t3 = new Thread (() ->
               System.out.println("Third Thread 3"));

       t.start();
       t2.start();
       t3.start();

       Thread.sleep(10);
       System.out.println("lets begin");
       t.join();

   }
}
