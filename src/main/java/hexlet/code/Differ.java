package hexlet.code;


import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        HashMap<String, Object> resultOfFirstFile = Parser.parseFile(pathToFile1);
        HashMap<String, Object> resultOfSecondFile = Parser.parseFile(pathToFile2);

        LinkedHashMap<String, Object> result = new LinkedHashMap();

        HashSet<String> keysSet = new HashSet<>();
        keysSet.addAll(resultOfFirstFile.keySet());
        keysSet.addAll(resultOfSecondFile.keySet());
        List<String> keys = keysSet.stream().sorted().collect(Collectors.toList());

        for (String s : keys) {
            if (resultOfFirstFile.containsKey(s) && resultOfSecondFile.containsKey(s)) {
                if (resultOfFirstFile.get(s).equals(resultOfSecondFile.get(s))) {
                    result.put("   " + s, resultOfFirstFile.get(s));
                } else {
                    result.put(" - " + s, resultOfFirstFile.get(s));
                    result.put(" + " + s, resultOfSecondFile.get(s));
                }
            } else if (resultOfFirstFile.containsKey(s) && !resultOfSecondFile.containsKey(s)) {
                result.put(" - " + s, resultOfFirstFile.get(s));
            } else if (!resultOfFirstFile.containsKey(s) && resultOfSecondFile.containsKey(s)) {
                result.put(" + " + s, resultOfSecondFile.get(s));
            }
        }

        return mapToString(result);
    }

    private static String mapToString(LinkedHashMap<String, Object> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Map.Entry<String, Object> pair : result.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue().toString();
            sb.append(" ").append(key).append(": ").append(value).append("\n");
        }
        sb.append("}");
        return String.valueOf(sb);
    }

}
