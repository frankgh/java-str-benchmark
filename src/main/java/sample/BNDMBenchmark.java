package sample;

import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.util.io.CharProvider;
import net.amygdalum.util.io.StringCharProvider;
import org.openjdk.jmh.annotations.Benchmark;

public class BNDMBenchmark implements BenchmarkConstants {

    @Benchmark
    public Object bndm(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.str, 0);
        StringFinder finder = BNDM_SHORT.createFinder(charProvider);
        return finder.findNext();
    }

    @Benchmark
    public Object bndmLong(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.strLong, 0);
        StringFinder finder = BNDM_LONG.createFinder(charProvider);
        return finder.findNext();
    }

    public static void main(String[] args) {
        System.out.println(new BNDMBenchmark().bndm(new BenchmarkState()));
        System.out.println(new BNDMBenchmark().bndmLong(new BenchmarkState()));
    }
}
