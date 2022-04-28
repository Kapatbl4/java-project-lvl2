package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormatter(List<Map<String, Object>> interimDiff, String format) {
        if (format.equals("plain")) {
            return Plain.plain(interimDiff);
        }
        return Stylish.stylish(interimDiff);
    }
}
