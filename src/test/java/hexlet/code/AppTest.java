package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String expected;
    private static String expectedStylish;
    private static String expectedPlain;

    @BeforeAll
    static void setExpected() {
        expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
    }

    @BeforeAll
    static void setExpected1() {
        expectedStylish = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
    }

    @BeforeAll
    static void setPlain() {
        expectedPlain = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
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
    public void testRecursiveJsonStylish() throws IOException {
        assertEquals(expectedStylish, Differ.generate("src/test/file3.json",
                "src/test/file4.json"));
    }

    @Test
    public void testRecursiveYmlStylish() throws IOException {
        assertEquals(expectedStylish, Differ.generate("src/test/file3.yml",
                "src/test/file4.yml"));
    }

    @Test
    public void testJsonPlain() throws IOException {
        assertEquals(expectedPlain, Differ.generate("src/test/file3.json",
                "src/test/file4.json", "plain"));
    }

    @Test
    public void testRecursiveYmlPlain() throws IOException {
        assertEquals(expectedPlain, Differ.generate("src/test/file3.yml",
                "src/test/file4.yml", "plain"));
    }

}
