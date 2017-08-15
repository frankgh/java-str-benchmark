package sample;

import org.junit.Assert;
import org.junit.Test;

public class KMPTest extends Assert {

    @Test
    public void test() {
        verify("Hello world", "world");
        verify("中国人民", "人民");
    }

    public void verify(String text, String keyword) {
        assertEquals(text.indexOf(keyword), new KMP(keyword).search(text));
    }
}
