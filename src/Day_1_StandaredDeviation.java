package src;

import java.io.*;
import java.util.*;

public class Day_1_StandaredDeviation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(10);
        ArrayList<Integer> x = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            x.add(sc.nextInt(10));
        }
        double mean = 0;
        for (int i = 0; i < n; ++i) {
            mean += (double) x.get(i) / n;
        }
        double variance = 0;
        for (int i = 0; i < n; ++i) {
            double t = x.get(i) - mean;
            variance += (t * t) / n;
        }
        double stDev = Math.sqrt(variance);
        System.out.println(String.format("%.1f", stDev));
    }
}
