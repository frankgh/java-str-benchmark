package sample;

import net.amygdalum.stringsearchalgorithms.search.chars.BOM;
import net.amygdalum.stringsearchalgorithms.search.chars.Horspool;
import net.amygdalum.stringsearchalgorithms.search.chars.ShiftOr;
import org.ahocorasick.trie.Trie;
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

    KMP KMP_SHORT = new KMP(TGT);
    KMP KMP_LONG = new KMP(TGT_LONG);

    Trie TRIE_SHORT = Trie.builder().addKeyword(TGT).build();
    Trie TRIE_LONG = Trie.builder().addKeyword(TGT_LONG).build();

    Horspool HORSPOOL_SHORT = new Horspool(TGT);
    Horspool HORSPOOL_LONG = new Horspool(TGT_LONG);

    ShiftOr SHIFT_OR = new ShiftOr(TGT);
    ShiftOr SHIFT_OR_LONG = new ShiftOr(TGT_LONG);

    BOM BOM_SHORT = new BOM(TGT);
    BOM BOM_LONG = new BOM(TGT_LONG);

    @State(Scope.Benchmark)
    class BenchmarkState {
        volatile String str = TEXT;
        volatile String strLong = TEXT_LONG;
        volatile KMP kmpStr = KMP_SHORT;
        volatile KMP kmpLong = KMP_LONG;
        volatile Trie trie = TRIE_SHORT;
        volatile Trie trieLong = TRIE_LONG;
        volatile Horspool horspool = HORSPOOL_SHORT;
        volatile Horspool horspoolLong = HORSPOOL_LONG;
    }

}
