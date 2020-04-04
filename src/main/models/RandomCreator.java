/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;


import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Mike
 */
public class RandomCreator {

   
    private static final ArrayList<Integer> times = new ArrayList<>();

    public static ArrayList<Double> createRandomFreq() {
        ArrayList<Double> frequencies = new ArrayList<Double>();
        frequencies.add(523.25);
        frequencies.add(587.33);
        frequencies.add(659.25);
        frequencies.add(698.46);
        frequencies.add(783.99);
        frequencies.add(880.00);
        frequencies.add(987.77);
        frequencies.add(1046.50);
        return frequencies;
    }

    public static ArrayList<Integer> createRandomTimestamps() {
        ArrayList<Integer> times = new ArrayList<>();
        times.add(1000);
        times.add(500);
        times.add(250);
//        times.add(125);
        return times;
    }

    public static double getRandomFreq(ArrayList<Double> frequencies) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, frequencies.size());
        return createRandomFreq().get(randomNum);
    }
    
    public static int getRandomTimestamp(ArrayList<Integer> times) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, times.size());
        return createRandomTimestamps().get(randomNum);
    }
    
    

}
