package hexlet.code.formatters;

import hexlet.code.Status;
import java.util.Map;
import java.util.Set;

public class Stylish {
    public static String getStylishFormat(Map<String, Status> data) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        Set<String> keys = data.keySet();
        for (String key: keys) {
            String status = data.get(key).getStatus();
            switch (status) {
                case "unmodified":
                    result.append("    ");
                    result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
                    break;
                case "deleted":
                    result.append("  - ");
                    result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
                    break;
                case "added":
                    result.append("  + ");
                    result.append(key).append(": ").append(data.get(key).getValue2()).append("\n");
                    break;
                case "updated":
                    result.append("  - ");
                    result.append(key).append(": ").append(data.get(key).getValue1()).append("\n");
                    result.append("  + ");
                    result.append(key).append(": ").append(data.get(key).getValue2()).append("\n");
                    break;
                default:
                    throw new RuntimeException("unknown status: " + status);
            }
        }
        result.append("}");
        return result.toString().trim();
    }
}
