/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

public class Oscillator {

    //
    private static final int SAMPLE_RATE = 16 * 1024;

    public static byte[] createSinWaveBuffer(double freq, int ms) {
        int samples = (int) ((ms * SAMPLE_RATE) / 1000);
        byte[] output = new byte[samples];
        //
        double period = (double) SAMPLE_RATE / freq;
        for (int i = 0; i < output.length; i++) {
            double angle = 2.0 * Math.PI * i / period;
            output[i] = (byte) (Math.sin(angle) * 127f);
        }

        return output;
    }

    public static int getSAMPLE_RATE() {
        return SAMPLE_RATE;
    }

}
