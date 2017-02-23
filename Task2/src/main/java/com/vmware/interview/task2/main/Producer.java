package com.vmware.interview.task2.main;

import com.vmware.interview.task2.utils.RandomIntGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Queue;

/**
 * Created by vardang on 2/18/17.
 */
public class Producer implements Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private final Queue<Integer> queue;
    private static volatile boolean isRunning = true;

    public static void stopProductions() {
        isRunning = false;
    }

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (isRunning) {

            try {
                synchronized (queue) {
                    while (queue.size() >= 100) {
                        queue.wait();
                    }
                    Thread.sleep(RandomIntGenerator.getRandomInt());
                    Integer randomInt = RandomIntGenerator.getRandomIntBetween(1, 100);
                    queue.add(randomInt);
                    queue.notifyAll();
                    LOGGER.debug(randomInt.toString());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

