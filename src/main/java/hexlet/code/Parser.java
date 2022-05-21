package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String format) throws IOException {
        ObjectMapper objectMapper = switch (format) {
            case ("json") -> new ObjectMapper(new JsonFactory());
            case ("yml") -> new ObjectMapper(new YAMLFactory());
            default -> throw new RuntimeException("unsupported file format");
        };

        return objectMapper.readValue(data, new TypeReference<Map<String, Object>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
    }
}
