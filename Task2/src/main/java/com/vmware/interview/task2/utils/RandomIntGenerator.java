package com.vmware.interview.task2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by vardang on 2/18/17.
 */
public class RandomIntGenerator {

    private static Random random = new Random();
    private static int defaultUpperBound = 100;
    private static int defaultLowerBound = 0;
    private static int defaultRange = defaultUpperBound - defaultLowerBound + 1;

    public static Integer getRandomInt() {
        return random.nextInt(defaultRange) + defaultLowerBound;
    }

    public static Integer getRandomIntBetween(int firstBound, int secondBound) {
        if (firstBound > secondBound){
            return random.nextInt(firstBound - secondBound + 1) + secondBound;
        }
        return random.nextInt(secondBound - firstBound + 1) + firstBound;
    }

    private RandomIntGenerator(){}
}
