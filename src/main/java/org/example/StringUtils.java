package org.example;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;

public class StringUtils {
    // I got carried away and wanted to benchmark different implementations.
    // reverse2 with an output char array and charAt method is by far the fastest.
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    public static String reverse2(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        char[] output = new char[input.length()];
        for (int i = input.length() - 1; i >= 0; i--) {
            output[input.length() - 1 - i] = input.charAt(i);
        }
        return new String(output);
    }

    public static String reverse3(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        char[] output = new char[input.length()];
        char[] inputArray = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            output[input.length() - 1 - i] = inputArray[i];
        }
        return new String(output);
    }

    public static String reverse4(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        char[] output = input.toCharArray();
        for (int i = 0; i < output.length / 2; i++) {
            char temp = output[i];
            output[i] = output[output.length - 1 - i];
            output[output.length - 1 - i] = temp;
        }
        return new String(output);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    public static String upperCase(String input) {
        return null;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void benchmark1() {
        reverse("Hello World");
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void benchmark2() {
        reverse2("Hello World");
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void benchmark3() {
        reverse3("Hello World");
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void benchmark4() {
        reverse4("Hello World");
    }
}
