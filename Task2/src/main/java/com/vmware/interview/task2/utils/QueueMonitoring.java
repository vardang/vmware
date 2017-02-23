package com.vmware.interview.task2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Queue;

/**
 * Created by vardang on 2/18/17.
 */
public class QueueMonitoring extends Thread {
    private final Logger LOGGER = LoggerFactory.getLogger(QueueMonitoring.class);
    private Queue<Integer> queue;
    private static volatile boolean isRunning = true;

    public static void stopMonitoring(){
        isRunning = false;
    }

    QueueMonitoring(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
            Integer size = queue.size();
            LOGGER.info("Queue size: " + size.toString() + "\n");
        }
    }

}
