/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;
import main.models.Oscillator;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import static main.models.Oscillator.createSinWaveBuffer;
import main.models.RandomCreator;

/**
 *
 * @author Mike
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException {
        final AudioFormat af = new AudioFormat(Oscillator.getSAMPLE_RATE(), 8, 1, true, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(af);
        line.open(af, Oscillator.getSAMPLE_RATE());
        line.start();

        boolean forwardNotBack = true;

        byte[] toneBuffer;
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> frequencies = RandomCreator.createRandomFreq();
        ArrayList<Integer> times = RandomCreator.createRandomTimestamps();
        String again = "y";
        while (again.equalsIgnoreCase("y")) {
            System.out.println("Type Yes to create a random melody");
            System.out.println("Type Exit to... exit.");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("yes")) {
                int totalTime = 0;
                while (totalTime < 16000) {
                    int time = RandomCreator.getRandomTimestamp(times);
                    double freq = RandomCreator.getRandomFreq(frequencies);
                    toneBuffer = createSinWaveBuffer(freq, time);
                    line.write(toneBuffer, 0, toneBuffer.length);
                    totalTime += time;
                }
            } else if (choice.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice.");
            }
            System.out.println("Do you wanna go again? (Y/N)");
            again = sc.next();
            if(again.equalsIgnoreCase("n")){
                System.exit(0);
            }
        }

//        byte[] toneBuffer = createSinWaveBuffer(523.25, 500);
//        line.write(toneBuffer, 0, toneBuffer.length);
//        toneBuffer = createSinWaveBuffer(587.33, 500);

        line.drain();
        line.close();
    }

}
