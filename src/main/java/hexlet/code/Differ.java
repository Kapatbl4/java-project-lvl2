package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Objects;


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

    public static List<LinkedHashMap<String, Object>> genInterimDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<LinkedHashMap<String, Object>> interimDiff = new ArrayList<>();
        TreeSet<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String s : keysSet) {
            LinkedHashMap<String, Object> element = new LinkedHashMap<>();
            element.put("fieldName", s);
            element.put("oldValue", map1.getOrDefault(s, "No old value"));
            element.put("newValue", map2.getOrDefault(s, "No new value"));

            element.put("status", genStatus(map1, map2, s));
            interimDiff.add(element);
        }
        return interimDiff;
    }

    private static String genStatus(Map<String, Object> map1, Map<String, Object> map2, String field) {
        if (!map1.containsKey(field)) {
            return "added";
        } else if (!map2.containsKey(field)) {
            return "deleted";
        } else if (Objects.equals(map1.get(field), map2.get(field))) {
            return "unchanged";
        }
        return "changed";
    }

}
