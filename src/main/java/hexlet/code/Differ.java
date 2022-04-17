package hexlet.code;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        File file1 = new File(pathToFile1);
        File file2 = new File(pathToFile2);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonParser parser1 = objectMapper.createParser(file1);
        JsonParser parser2 = objectMapper.createParser(file2);
        HashMap<String, Object> resultOfFirstFile = objectMapper.readValue(parser1, HashMap.class);
        HashMap<String, Object> resultOfSecondFile = objectMapper.readValue(parser2, HashMap.class);

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
