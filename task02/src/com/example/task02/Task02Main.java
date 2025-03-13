package com.example.task02;

import java.util.stream.IntStream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2).limit(10).forEach(System.out::println);
        cycleGrayCode(3).limit(10).forEach(System.out::println);
        cycleGrayCode(4).limit(10).forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("Error: n < 1 || n > 16");
        }

        int[] grayCodes = generateGrayCodes(n);

        return IntStream.iterate(0, i -> (i + 1) % grayCodes.length).map(i -> grayCodes[i]);
    }

    private static int[] generateGrayCodes(int n) {
        int size = 1 << n;
        int[] grayCodes = new int[size];

        for (int i = 0; i < size; i++) {
            grayCodes[i] = i ^ (i >> 1);
        }

        return grayCodes;
    }
}