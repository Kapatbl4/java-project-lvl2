package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.Objects;

public class Plain {
    public static String plain(List<Map<String, Object>> interimDiff) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : interimDiff) {
            if (map.get("status").equals("added")) {
                sb.append("Property '")
                        .append(map.get("fieldName"))
                        .append("' was added with value: ")
                        .append(elementToString(map.get("newValue")))
                        .append("\n");
            } else if (map.get("status").equals("deleted")) {
                sb.append("Property '")
                        .append(map.get("fieldName"))
                        .append("' was removed")
                        .append("\n");
            } else if (map.get("status").equals("changed")) {
                sb.append("Property '")
                        .append(map.get("fieldName"))
                        .append("' was updated. From ")
                        .append(elementToString(map.get("oldValue")))
                        .append(" to ")
                        .append(elementToString(map.get("newValue")))
                        .append("\n");
            }
        }
        return String.valueOf(sb).trim();
    }
    public static String elementToString(Object o) {
        if (o instanceof Collection || o instanceof Map) {
            return "[complex value]";
        }
        if (o instanceof String) {
            return "'" + o + "'";
        }
        return Objects.toString(o);
    }
}
