package hexlet.code.formatters;

import java.util.*;

public class Plain {
    public static String plain(List<LinkedHashMap<String, Object>> interimDiff) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : interimDiff) {
            if (map.get("status").equals("added")) {
                sb.append("Property '").
                        append(map.get("fieldName")).
                        append("' was added with value: ").
                        append(elementToString(map.get("newValue"))).
                        append("\n");
            } else if (map.get("status").equals("deleted")) {
                sb.append("Property '").
                        append(map.get("fieldName")).
                        append("' was removed").
                        append("\n");
            } else if (map.get("status").equals("changed")) {
                sb.append("Property '").
                        append(map.get("fieldName")).
                        append("' was updated. From ").
                        append(elementToString(map.get("oldValue"))).
                        append(" to ").
                        append(elementToString(map.get("newValue"))).
                        append("\n");
            }
        }
        return String.valueOf(sb).trim();
    }
    public static String elementToString(Object o) {
        if (o == null) {
            return "null";
        } else if (o instanceof List
                || o instanceof Map
                || o instanceof Set
                || o instanceof Arrays) {
            return "[complex value]";
        } else if (o instanceof String) {
            return "'" + o + "'";
        }
        return o.toString();
    }
}