package hexlet.code.formatters;

import hexlet.code.Status;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {
    public static String getPlainFormat(Map<String, Status> data) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = data.keySet();
        for (String key: keys) {
            String status = data.get(key).getStatus();
            switch (status) {
                case "deleted":
                    result.append("Property '");
                    result.append(key).append("' was removed").append("\n");
                    break;
                case "added":
                    result.append("Property '");
                    result.append(key).append("' was added with value: ").append(isComplex(data.get(key).getValue2()));
                    result.append("\n");
                    break;
                case "updated":
                    result.append("Property '");
                    result.append(key).append("' was updated. From ").append(isComplex(data.get(key).getValue1()));
                    result.append(" to ").append(isComplex(data.get(key).getValue2())).append("\n");
                    break;
                case "unmodified":
                    break;
                default:
                    throw new RuntimeException("unknown status: " + status);
            }
        }
        return result.toString().trim();
    }
    public static String isComplex(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
