package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedHashMap;
import java.util.List;

public class Formatter {
    public static String chooseFormatter(List<LinkedHashMap<String, Object>> interimDiff,
                                         String format) throws JsonProcessingException {
        String result;
        switch (format) {
            case ("plain") :
                result = Plain.plain(interimDiff);
                break;
            case ("json") :
                result = Json.json(interimDiff);
                break;
            case ("stylish") :
                result = Stylish.stylish(interimDiff);
                break;
            default: throw new RuntimeException("Unsupported format");
        }

        return result;
    }
}
