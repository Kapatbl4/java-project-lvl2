package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String expected;

    @BeforeAll
    static void setExpected() {
        expected = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";
    }

    @Test
    public void testJSON() throws Exception {
        assertEquals(expected, Differ.generate("src/test/file1.json",
                "src/test/file2.json"));
    }

    @Test
    public void testYML() throws Exception {
        assertEquals(expected, Differ.generate("src/test/file1.yml",
                "src/test/file2.yml"));
    }

}
