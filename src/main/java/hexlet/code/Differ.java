package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Differ {

    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        Map<String, Object> resultOfFirstFile = Parser.parseFile(pathToFile1);
        Map<String, Object> resultOfSecondFile = Parser.parseFile(pathToFile2);

        return Formatter.chooseFormatter(genInterimDiff(resultOfFirstFile, resultOfSecondFile), "");
    }

    public static String generate(String pathToFile1, String pathToFile2, String format) throws IOException {
        Map<String, Object> resultOfFirstFile = Parser.parseFile(pathToFile1);
        Map<String, Object> resultOfSecondFile = Parser.parseFile(pathToFile2);

        return Formatter.chooseFormatter(genInterimDiff(resultOfFirstFile, resultOfSecondFile), format);
    }

    public static List<Map<String, Object>> genInterimDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> interimDiff = new ArrayList<>();
        TreeSet<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String s : keysSet) {
            Map<String, Object> element = new HashMap<>();
            element.put("key", s);
            element.put("oldValue", map1.getOrDefault(s, "No old value"));
            element.put("newValue", map2.getOrDefault(s, "No new value"));

            if (element.get("oldValue") == null && element.get("newValue") == null) {
                element.put("status", "unchanged");
            } else if (element.get("oldValue") == null && element.get("newValue") != null) {
                if (element.get("newValue").equals("No new value")) {
                    element.put("status", "deleted");
                } else {
                    element.put("status", "changed");
                }
            } else if (element.get("oldValue") != null && element.get("newValue") == null) {
                if (element.get("oldValue").equals("No old value")) {
                    element.put("status", "added");
                } else {
                    element.put("status", "changed");
                }
            } else if (element.get("oldValue") != null && element.get("newValue") != null) {
                if (element.get("oldValue").equals("No old value") && !element.get("newValue").equals("No new value")) {
                    element.put("status", "added");
                } else if (!element.get("oldValue").equals("No old value")
                        && element.get("newValue").equals("No new value")) {
                    element.put("status", "deleted");
                } else if (element.get("oldValue").equals(element.get("newValue"))) {
                    element.put("status", "unchanged");
                } else {
                    element.put("status", "changed");
                }
            }
            interimDiff.add(element);
        }
        return interimDiff;
    }

}
