package com.vmware.interview.task2.main;

import com.vmware.interview.task2.utils.ThreadPoolConstructor;
import com.vmware.interview.task2.utils.UI;

/**
 * Created by vardang on 2/18/17.
 */
public class Main {
    public static void main(String[] args) {
        UI.init();
        int numberOfProducers = UI.getNumberOfProducers();
        int numberOfCustomers = UI.getNumberOfConsumers();
        ThreadPoolConstructor threadPoolConstructor = new ThreadPoolConstructor(numberOfProducers, numberOfCustomers);
        threadPoolConstructor.initThreads();
        UI.waitUser();
        threadPoolConstructor.interruptProducers();
        threadPoolConstructor.finish();

    }
}
