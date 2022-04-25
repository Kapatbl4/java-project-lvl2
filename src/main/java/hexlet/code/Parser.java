package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Parser {
    public static String readData(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        return Files.readString(path);
    }

    public static HashMap<String, Object> parseFile(String path) throws IOException {
        HashMap<String, Object> result;
        ObjectMapper objectMapper;
        if (path.endsWith(".json")) {
            objectMapper = new ObjectMapper(new JsonFactory());
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        result = objectMapper.readValue(readData(path), HashMap.class);
        return result;
    }
}
