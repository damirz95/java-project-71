package hexlet.code;

/*import java.util.ArrayList;
import java.util.List;*/
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferBuilder {
    public static String differ(Map<String, Object> dataOne, Map<String, Object> dataTwo) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(dataOne.keySet());
        keys.addAll(dataTwo.keySet());
        System.out.println(keys);
        for (String key: keys) {
            if (Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Unmodified
                result.append("  ").append(key).append(": ").append(dataOne.get(key)).append("\n");
            } else if (!dataOne.containsKey(key)) {
                //Add data
                result.append("+ ").append(key).append(": ").append(dataTwo.get(key)).append("\n");
            } else if (!dataTwo.containsKey(key)) {
                //Del
                result.append("- ").append(key).append(": ").append(dataOne.get(key)).append("\n");
            } else if (!Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Update
                result.append("- ").append(key).append(": ").append(dataOne.get(key)).append("\n");
                result.append("+ ").append(key).append(": ").append(dataTwo.get(key)).append("\n");
            }
        }
        /*dataOne.forEach((key, value) -> {
            if (dataTwo.containsKey(key) && dataTwo.containsValue(value)) {
                result.put(key, value);
            } else if (dataTwo.containsKey(key) && !dataTwo.containsValue(value)) {
                result.put("- " + key, value);
            } else {
                result.put("- " + key, value);
            }
        });
        dataTwo.forEach((key, value) -> {
            if (!dataOne.containsKey(key)) {
                result.put("+ " + key, value);
            } else if (dataOne.containsKey(key) && !dataOne.containsValue(value)) {
                result.put("+ " + key, value);
            }
            });*/
        return result.toString();
    }
}
