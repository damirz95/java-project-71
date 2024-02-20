package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Plain {
    public static String getPlainFormat(Map<String, Status> data) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(data.keySet());
        for (String key: keys) {
            if (data.get(key).getStatus().equals("deleted")) {
                result.append("Property '");
                result.append(key).append("' was removed").append("\n");
            } else if (data.get(key).getStatus().equals("added")) {
                result.append("Property '");
                result.append(key).append("' was added with value: '").append(data.get(key).getValue2()).append("'\n");
            } else if (data.get(key).getStatus().equals("updated")) {
                result.append("Property '");
                result.append(key).append("' was updated. From '").append(data.get(key).getValue1()).append("' to '");
                result.append(data.get(key).getValue2()).append("'\n");
            }
        }
        return result.toString();
    }
}
