package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String expected;
    private static String expected1;

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

    @BeforeAll
    static void setExpected1() {
        expected1 = "{\n" +
                "    chars1: [a, b, c]\n" +
                "  - chars2: [d, e, f]\n" +
                "  + chars2: false\n" +
                "  - checked: false\n" +
                "  + checked: true\n" +
                "  - default: null\n" +
                "  + default: [value1, value2]\n" +
                "  - id: 45\n" +
                "  + id: null\n" +
                "  - key1: value1\n" +
                "  + key2: value2\n" +
                "    numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [2, 3, 4, 5]\n" +
                "  + numbers2: [22, 33, 44, 55]\n" +
                "  - numbers3: [3, 4, 5]\n" +
                "  + numbers4: [4, 5, 6]\n" +
                "  + obj1: {nestedKey=value, isNested=true}\n" +
                "  - setting1: Some value\n" +
                "  + setting1: Another value\n" +
                "  - setting2: 200\n" +
                "  + setting2: 300\n" +
                "  - setting3: true\n" +
                "  + setting3: none\n" +
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

    @Test
    public void testRecursiveJSON() throws IOException {
        assertEquals(expected1, Differ.generate("src/test/file3.json",
                "src/test/file4.json"));
    }

    @Test
    public void testRecursiveYML() throws IOException {
        assertEquals(expected1, Differ.generate("src/test/file3.yml",
                "src/test/file4.yml"));
    }

}
