package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String expected;
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;


    @Test
    public void testJSON() throws Exception {
        expected = Files.readString(Path.of("src/test/resources/expected"));
        assertEquals(expected, Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json"));
    }

    @Test
    public void testYML() throws Exception {
        expected = Files.readString(Path.of("src/test/resources/expected"));
        assertEquals(expected, Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml"));
    }

    @Test
    public void testRecursiveJsonStylish() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/expectedStylish"));
        assertEquals(expectedStylish, Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file4.json"));
    }

    @Test
    public void testRecursiveYmlStylish() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/expectedStylish"));
        assertEquals(expectedStylish, Differ.generate("src/test/resources/file3.yml",
                "src/test/resources/file4.yml"));
    }

    @Test
    public void testJsonPlain() throws IOException {
        expectedPlain = Files.readString(Path.of("src/test/resources/expectedPlain"));
        assertEquals(expectedPlain, Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file4.json", "plain"));
    }

    @Test
    public void testRecursiveYmlPlain() throws IOException {
        expectedPlain = Files.readString(Path.of("src/test/resources/expectedPlain"));
        assertEquals(expectedPlain, Differ.generate("src/test/resources/file3.yml",
                "src/test/resources/file4.yml", "plain"));
    }

    @Test
    public void testStylish() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/expectedStylish"));
        assertEquals(expectedStylish, Differ.generate("src/test/resources/file3.yml",
                "src/test/resources/file4.yml", "stylish"));
    }

    @Test
    public void testJsonFormat() throws IOException {
        expectedJson = Files.readString(Path.of("src/test/resources/expectedJson"));
        assertEquals(expectedJson, Differ.generate("src/test/resources/file3.yml",
                "src/test/resources/file4.yml", "json"));
    }

}
