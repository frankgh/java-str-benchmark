package sample;

public class KMP {
    private Integer[] table;
    private char[] pattern;

    public KMP(String pattern) {
        this.pattern = pattern.toCharArray();
        char[] w = this.pattern;

        table = new Integer[w.length < 2 ? 2 : w.length];
        int pos = 2; // cur pos to compute in T
        int cnd = 0; // index of W of next character of cur candidate substr

        // first few values are fixed
        table[0] = -1;  // table[0] := -1
        table[1] = 0;   // table[1] := 0

        while (pos < w.length) {
            // first case: substring is still good
            if (w[pos - 1] == w[cnd]) {
                cnd += 1;
                table[pos] = cnd;
                pos += 1;
            } else if (cnd > 0)
                cnd = table[cnd];
            else {
                table[pos] = 0;
                pos += 1;
            }
        }
    }

    /** Has the same semantics as str.indexOf(pattern) */
    public int search(String str) {
        char[] s = str.toCharArray();
        char[] w = this.pattern;

        if (w.length == 0) // substr is empty string
            return 0;
        if (s.length == 0) // text is empty, can't be found
            return -1;
        int m = 0; // index of beg. of current match in S
        int i = 0; // pos. of cur char in W

        while (m + i < s.length) {
            if (w[i] == s[m + i]) {
                if (i == w.length - 1)
                    return m;
                i += 1;
            } else {
                m = (m + i - table[i]);
                if (table[i] > -1)
                    i = table[i];
                else
                    i = 0;
            }
        }
        return -1;
    }
}
