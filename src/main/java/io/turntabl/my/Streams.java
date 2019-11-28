package io.turntabl.my;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams  extends Thread {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(0,10)
                .mapToObj(t ->new Thread(() ->{
            while (!Thread.interrupted()){}
                System.out.println("Thread " + t + "interrupted");
                }))
                .collect(Collectors.toList());
        threads.forEach((Thread::start));
        System.out.println("Active " + Thread.activeCount());
        Random rand = new Random();
        while(Thread.activeCount() != 1) {
            Thread.sleep(100);
            threads.get(rand.nextInt(10)).interrupt();
        }

        Thread.sleep(1000);
        System.out.println("hello from this thread");
        }

    }




