package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Status> data, String format) throws JsonProcessingException {
        if (format.equals("plain")) {
            return Plain.getPlainFormat(data);
        } else if (format.equals("stylish")) {
            return Stylish.getStylishFormat(data);
        } else if (format.equals("json")) {
            return Json.getJsonFormat(data);
        } else {
            throw new RuntimeException("unknown format: " + format);
        }
    }
}
