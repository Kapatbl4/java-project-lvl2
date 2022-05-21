package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> interimDiff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map<String, Object> map : interimDiff) {
            sb.append("\n");
            if (map.get("status").equals("unchanged")) {
                sb.append("    ")
                        .append(map.get("fieldName"))
                        .append(": ")
                        .append(map.get("oldValue"));
            } else if (map.get("status").equals("added")) {
                sb.append("  + ")
                        .append(map.get("fieldName"))
                        .append(": ")
                        .append(map.get("newValue"));
            } else if (map.get("status").equals("deleted")) {
                sb.append("  - ")
                        .append(map.get("fieldName"))
                        .append(": ")
                        .append(map.get("oldValue"));
            } else if (map.get("status").equals("changed")) {
                sb.append("  - ")
                        .append(map.get("fieldName"))
                        .append(": ")
                        .append(map.get("oldValue"))
                        .append("\n")
                        .append("  + ")
                        .append(map.get("fieldName"))
                        .append(": ")
                        .append(map.get("newValue"));
            }
        }
        sb.append("\n}");
        return String.valueOf(sb);
    }

}
