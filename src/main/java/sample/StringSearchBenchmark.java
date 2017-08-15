package sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.RunnerException;

public class StringSearchBenchmark implements BenchmarkConstants{

    @Benchmark
    public Object kmp(BenchmarkState state) {
        return new KMP(TGT).search(state.str);
    }

    @Benchmark
    public Object kmpPrecompiled(BenchmarkState state) {
        return state.kmpStr.search(state.str);
    }

    @Benchmark
    public Object string(BenchmarkState state) {
        return state.str.indexOf(TGT);
    }

    @Benchmark
    public Object kmpLong(BenchmarkState state) {
        return new KMP(TGT_LONG).search(state.strLong);
    }

    @Benchmark
    public Object kmpPrecompiledLong(BenchmarkState state) {
        return state.kmpLong.search(state.strLong);
    }

    @Benchmark
    public Object stringLong(BenchmarkState state) {
        return state.strLong.indexOf(TGT_LONG);
    }

    public static void main(String[] args) throws RunnerException {
        BenchmarkState state = new BenchmarkState();
        StringSearchBenchmark bk = new StringSearchBenchmark();
        System.out.println(bk.kmp(state));
        System.out.println(bk.kmpLong(state));
        System.out.println(bk.kmpPrecompiled(state));
        System.out.println(bk.kmpPrecompiledLong(state));
        System.out.println(bk.string(state));
        System.out.println(bk.stringLong(state));
//        Options opt = new OptionsBuilder().include(StringSearchBenchmark.class.getSimpleName()).warmupIterations(5)
//                .measurementIterations(5).forks(1).build();
//        new Runner(opt).run();
    }



}
