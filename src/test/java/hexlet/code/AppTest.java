package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String expected;
    @BeforeAll
    static void setFile() throws IOException {
        expected = Files.readString(Path.of("src/test/expected.json"));
    }

    @Test
    public void testStandard() throws Exception {
        assertEquals(expected, Differ.generate("src/test/file1.json",
                "src/test/file2.json"));
    }

}
