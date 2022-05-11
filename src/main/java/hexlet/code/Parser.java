package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

public class Parser {

    public static HashMap<String, Object> parseFile(String data, String fileformat) throws IOException {
        HashMap<String, Object> result;
        ObjectMapper objectMapper;
        switch (fileformat) {
            case (".json") :
                objectMapper = new ObjectMapper(new JsonFactory());
                break;
            case (".yml") :
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;
            default: throw new RuntimeException("unsupported file format");
        }

        result = objectMapper.readValue(data, HashMap.class);
        return result;
    }
}
