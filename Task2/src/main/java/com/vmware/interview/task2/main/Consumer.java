package com.vmware.interview.task2.main;

import com.vmware.interview.task2.utils.RandomIntGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Queue;

/**
 * Created by vardang on 2/18/17.
 */
public class Consumer implements Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private final Queue<Integer> queue;
    private static volatile boolean isRunning = true;

    public static void stopConsumption() {
        isRunning = false;
    }

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (isRunning){
            try {
                Thread.sleep(RandomIntGenerator.getRandomInt());
                synchronized (queue) {
                    while (queue.isEmpty()){
                        queue.wait();
                    }
                    Integer integer = queue.poll();
                    LOGGER.info(integer != null ? integer.toString() : "queue is empty");
                    if (queue.size() <= 80) {
                        queue.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                LOGGER.debug(e.getMessage());
            }
        }
    }
}
