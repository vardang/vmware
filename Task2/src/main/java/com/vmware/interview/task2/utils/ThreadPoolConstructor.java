package com.vmware.interview.task2.utils;

import com.vmware.interview.task2.main.Consumer;
import com.vmware.interview.task2.main.Producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by vardang on 2/18/17.
 */
public class ThreadPoolConstructor {

    private ExecutorService executorServiceProducers;
    private ExecutorService executorServiceConsumers;
    private int numberOfProducers;
    private int numberOfConsumers;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private QueueMonitoring queueMonitoring = new QueueMonitoring(queue);

    public ThreadPoolConstructor(int numberOfProducers, int numberOfConsumers) {
        this.numberOfProducers = numberOfProducers;
        this.numberOfConsumers = numberOfConsumers;
        executorServiceProducers = Executors.newFixedThreadPool(numberOfProducers);
        executorServiceConsumers = Executors.newFixedThreadPool(numberOfConsumers);
    }

    public void initThreads() {
        queueMonitoring.start();
        for (int i = 0; i < numberOfProducers; i++) {
            executorServiceProducers.submit(new Producer(queue));
        }
        for (int i = 0; i < numberOfConsumers; i++) {
            executorServiceConsumers.submit(new Consumer(queue));
        }
        executorServiceProducers.shutdown();
        executorServiceConsumers.shutdown();
    }

    public void interruptProducers() {
        Producer.stopProductions();
    }

    public void finish(){
        while (!(executorServiceProducers.isTerminated() && queue.isEmpty())){
            // wait until production is completed and queue is empty
        }
        Consumer.stopConsumption();
        QueueMonitoring.stopMonitoring();
        executorServiceConsumers.shutdownNow();
        executorServiceProducers.shutdownNow();
    }

}
