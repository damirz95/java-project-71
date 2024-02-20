package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String getFormattedText(Map<String, Status> data, String format) {
        if (format.equals("plain")) {
            return Plain.getPlainFormat(data);
        } else {
            return Stylish.getStylishFormat(data);
        }
    }
}
