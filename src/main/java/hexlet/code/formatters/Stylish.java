package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Stylish {
    private static final int COUNT_OF_SPACES_FOR_UNCHANGED = 4;
    public static String stylish(List<LinkedHashMap<String, Object>> interimDiff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map<String, Object> map : interimDiff) {
            sb.append("\n");
            if (map.get("status").equals("unchanged")) {
                sb.append(makeSpaces(COUNT_OF_SPACES_FOR_UNCHANGED)).
                        append(map.get("fieldName")).
                        append(": ").
                        append(map.get("oldValue") == null ? null : map.get("oldValue").toString());
            } else if (map.get("status").equals("added")) {
                sb.append(makeSpaces(2)).
                        append("+ ").
                        append(map.get("fieldName")).
                        append(": ").
                        append(map.get("newValue") == null ? null : map.get("newValue").toString());
            } else if (map.get("status").equals("deleted")) {
                sb.append(makeSpaces(2)).
                        append("- ").
                        append(map.get("fieldName")).
                        append(": ").
                        append(map.get("oldValue") == null ? null : map.get("oldValue").toString());
            } else if (map.get("status").equals("changed")) {
                sb.append(makeSpaces(2)).
                        append("- ").
                        append(map.get("fieldName")).
                        append(": ").
                        append(map.get("oldValue") == null ? null : map.get("oldValue").toString()).
                        append("\n").
                        append(makeSpaces(2)).
                        append("+ ").
                        append(map.get("fieldName")).
                        append(": ").
                        append(map.get("newValue") == null ? null : map.get("newValue").toString());
            }
        }
        sb.append("\n}");
        return String.valueOf(sb);
    }
    public static String makeSpaces(int i) {
        return " ".repeat(i);
    }
}
