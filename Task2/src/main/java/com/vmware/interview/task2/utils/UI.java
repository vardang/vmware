package com.vmware.interview.task2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by vardang on 2/18/17.
 */
public class UI {
    private static final Logger LOGGER = LoggerFactory.getLogger(UI.class);
    private static int numberOfConsumers;
    private static int numberOfProducers;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String WELCOME_MESSAGE = "Please enter number of ";
    private static final String RANGE_MESSAGE = " between " + MIN + " and " + MAX;
    private static final String CONSUMERS = "Consumers";
    private static final String PRODUCERS = "Producers";

    private UI(){

    }

    public static int getNumberOfConsumers() {
        return numberOfConsumers;
    }

    public static int getNumberOfProducers() {
        return numberOfProducers;
    }

    private static int getDataFromKeyboard(String economySystemItem){
        LOGGER.info(WELCOME_MESSAGE + economySystemItem + RANGE_MESSAGE + ": ");
        int input = 0;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()){
            input = in.nextInt();
        }
        if (input < MIN || input > MAX){
            LOGGER.info("Invalid input...\r\n");

            getDataFromKeyboard(economySystemItem);
        }
        return input;
    }

    public static void init(){
        numberOfProducers = getDataFromKeyboard(PRODUCERS);
        numberOfConsumers = getDataFromKeyboard(CONSUMERS);
    }

    public static void waitUser(){
        LOGGER.info("Hit enter to stop productions ...\n");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }


}
