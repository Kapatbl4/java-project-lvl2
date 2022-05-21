package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Objects;


public class Differ {

    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        return generate(pathToFile1, pathToFile2, "stylish");
    }

    public static String generate(String pathToFile1, String pathToFile2, String format) throws IOException {
        String data1 = readData(pathToFile1);
        String data2 = readData(pathToFile2);
        Map<String, Object> resultOfFirstFile = Parser.parse(data1, getFileFormat(pathToFile1));
        Map<String, Object> resultOfSecondFile = Parser.parse(data2, getFileFormat(pathToFile2));

        return Formatter.format(genInterimDiff(resultOfFirstFile, resultOfSecondFile), format);
    }

    public static List<Map<String, Object>> genInterimDiff(Map<String, Object> map1,
                                                                     Map<String, Object> map2) {
        List<Map<String, Object>> interimDiff = new ArrayList<>();
        TreeSet<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String s : keysSet) {
            HashMap<String, Object> element = new HashMap<>();
            element.put("fieldName", s);
            element.put("oldValue", map1.getOrDefault(s, null));
            element.put("newValue", map2.getOrDefault(s, null));

            element.put("status", genStatus(map1, map2, s));
            interimDiff.add(element);
        }
        return interimDiff;
    }

    private static String genStatus(Map<String, Object> map1, Map<String, Object> map2, String field) {
        if (!map1.containsKey(field)) {
            return "added";
        }
        if (!map2.containsKey(field)) {
            return "deleted";
        }
        if (Objects.equals(map1.get(field), map2.get(field))) {
            return "unchanged";
        }
        return "changed";
    }

    public static String readData(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        return Files.readString(path);
    }

    public static String getFileFormat(String filename) {
        String result;
        if (filename.endsWith("json")) {
            result = "json";
        } else if (filename.endsWith("yml") || filename.endsWith("yaml")) {
            result = "yml";
        } else {
            result = "unsupported file format";
        }
        return result;
    }

}
