package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map parse(String content, String format) throws Exception {
        if (format.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, Map.class);
        } else if (format.equals("yml")) {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            return  objectMapper.readValue(content, Map.class);
        } else {
            throw new Exception("Unknown data format: " + format);
        }
    }
}
