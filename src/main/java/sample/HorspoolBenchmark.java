package sample;

import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.util.io.CharProvider;
import net.amygdalum.util.io.StringCharProvider;
import org.openjdk.jmh.annotations.Benchmark;

public class HorspoolBenchmark implements BenchmarkConstants {

    @Benchmark
    public Object horspool(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.str, 0);
        StringFinder finder = state.horspool.createFinder(charProvider);
        return finder.findNext();
    }

    @Benchmark
    public Object horspoolLong(BenchmarkState state) {
        CharProvider charProvider = new StringCharProvider(state.strLong, 0);
        StringFinder finder = state.horspoolLong.createFinder(charProvider);
        return finder.findNext();
    }

    public static void main(String[] args) {
        System.out.println(new HorspoolBenchmark().horspool(new BenchmarkState()));
        System.out.println(new HorspoolBenchmark().horspoolLong(new BenchmarkState()));
    }
}
