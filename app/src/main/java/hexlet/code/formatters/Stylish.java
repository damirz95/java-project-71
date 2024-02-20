package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Stylish {
    public static String getStylishFormat(Map<String, Status> data) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(data.keySet());
        for (String key: keys) {
            if (data.get(key).getStatus().equals("unmodified")) {
                result.append("  ");
                result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
            } else if (data.get(key).getStatus().equals("deleted")) {
                result.append("- ");
                result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
            } else if (data.get(key).getStatus().equals("added")) {
                result.append("+ ");
                result.append(key).append(": ").append(data.get(key).getValue2()).append("\n");
            } else if (data.get(key).getStatus().equals("updated")) {
                result.append("- ");
                result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
                result.append("+ ");
                result.append(key).append(": ").append(data.get(key).getValue2()).append("\n");
            }
        }
        return result.toString();
    }
}
