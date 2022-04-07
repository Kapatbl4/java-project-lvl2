package hexlet.code;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Differ {
    private static Path pathToFile1;
    private static Path pathToFile2;
    public static String generate() throws IOException {
        File file1 = pathToFile1.toFile();
        File file2 = pathToFile2.toFile();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonParser parser1 = objectMapper.createParser(file1);
        JsonParser parser2 = objectMapper.createParser(file2);
        HashMap<String, Object> resultOfFirstFile = objectMapper.readValue(parser1, HashMap.class);
        HashMap<String, Object> resultOfSecondFile = objectMapper.readValue(parser2, HashMap.class);

        HashMap <String, Object> result = new HashMap();

        HashSet<String> keysSet = new HashSet<>();
        keysSet.addAll(resultOfFirstFile.keySet());
        keysSet.addAll(resultOfSecondFile.keySet());
        List<String> keys = keysSet.stream().sorted().collect(Collectors.toList());

        for (String s : keys) {
            if (resultOfFirstFile.containsKey(s) && resultOfSecondFile.containsKey(s)) {
                if (resultOfFirstFile.get(s).equals(resultOfSecondFile.get(s))) {
                    result.put("  " + s, resultOfFirstFile.get(s));
                } else {
                    result.put("- " + s, resultOfFirstFile.get(s));
                    result.put("+ " + s, resultOfSecondFile.get(s));
                }
            } else if(resultOfFirstFile.containsKey(s) && !resultOfSecondFile.containsKey(s)) {
                result.put("- " + s, resultOfFirstFile.get(s));
            } else if(!resultOfFirstFile.containsKey(s) && resultOfSecondFile.containsKey(s)) {
                result.put("+ " + s, resultOfSecondFile.get(s));
            }
        }
        return result.toString();
    }

    public static void setPathToFile1(String path) {
        pathToFile1 = Path.of(path);
    }
    public static void setPathToFile2(String path) {
        pathToFile2 = Path.of(path);
    }
}
