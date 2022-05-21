package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;
import java.util.List;

public class Formatter {
    public static String format(List<Map<String, Object>> interimDiff,
                                         String format) throws JsonProcessingException {
        return switch (format) {
            case ("plain") -> Plain.plain(interimDiff);
            case ("json") -> Json.json(interimDiff);
            case ("stylish") -> Stylish.stylish(interimDiff);
            default -> throw new RuntimeException("Unsupported format");
        };
    }
}
