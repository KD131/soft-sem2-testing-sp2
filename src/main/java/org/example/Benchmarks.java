package org.example;


import org.openjdk.jmh.annotations.*;

import java.io.IOException;

import static org.example.StringUtils.*;

@BenchmarkMode(Mode.Throughput)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
public class Benchmarks {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
    
    @Benchmark
    public void benchmark1() {
        reverse("Hello World");
    }

    @Benchmark
    public void benchmark2() {
        reverse2("Hello World");
    }

    @Benchmark
    public void benchmark3() {
        reverse3("Hello World");
    }

    @Benchmark
    public void benchmark4() {
        reverse4("Hello World");
    }
}
