package sample;

import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.util.io.CharProvider;
import net.amygdalum.util.io.StringCharProvider;
import org.openjdk.jmh.annotations.Benchmark;

public class ShiftOrBenchmark implements BenchmarkConstants {

    @Benchmark
    public Object shiftOr(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.str, 0);
        StringFinder finder = SHIFT_OR.createFinder(charProvider);
        return finder.findNext();
    }

    @Benchmark
    public Object shiftOrLong(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.strLong, 0);
        StringFinder finder = SHIFT_OR_LONG.createFinder(charProvider);
        return finder.findNext();
    }

    public static void main(String[] args) {
        System.out.println(new ShiftOrBenchmark().shiftOr(new BenchmarkState()));
        System.out.println(new ShiftOrBenchmark().shiftOrLong(new BenchmarkState()));
    }
}
