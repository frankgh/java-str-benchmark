package sample;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.osgl.util.IO;

public interface BenchmarkConstants {
    String TGT_NO_MATCH = "XYZ";
    String TGT = "algorithm";
    String REPLACEMENT = "method";
    String TEXT = "BMH algorithm is the fast and easy to implement";

    String TGT_NO_MATCH_LONG = "aaaxyz0001";
    String TGT_LONG = "encountered";
    String REP_LONG = "found";
    String TEXT_LONG = IO.readContentAsString(StringReplaceBenchmark.class.getResource("/long_str.txt"));

    @State(Scope.Benchmark)
    class BenchmarkState {
        volatile String str = TEXT;
        volatile String strLong = TEXT_LONG;
        volatile KMP kmpStr = new KMP(TGT);
        volatile KMP kmpLong = new KMP(TGT_LONG);
    }

}
