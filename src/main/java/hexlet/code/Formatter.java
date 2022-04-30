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
        if (format.equals("plain")) {
            return Plain.plain(interimDiff);
        } else if (format.equals("json")) {
            return Json.json(interimDiff);
        }
        return Stylish.stylish(interimDiff);
    }
}
