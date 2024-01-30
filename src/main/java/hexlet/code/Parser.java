package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Map.class);
    }
}
