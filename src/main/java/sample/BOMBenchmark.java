package sample;

import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.util.io.CharProvider;
import net.amygdalum.util.io.StringCharProvider;
import org.openjdk.jmh.annotations.Benchmark;

public class BOMBenchmark implements BenchmarkConstants {

    @Benchmark
    public Object bom(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.str, 0);
        StringFinder finder = BOM_SHORT.createFinder(charProvider);
        return finder.findNext();
    }

    @Benchmark
    public Object bomLong(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.strLong, 0);
        StringFinder finder = BOM_LONG.createFinder(charProvider);
        return finder.findNext();
    }

    public static void main(String[] args) {
        System.out.println(new BOMBenchmark().bom(new BenchmarkState()));
        System.out.println(new BOMBenchmark().bomLong(new BenchmarkState()));
    }
}
