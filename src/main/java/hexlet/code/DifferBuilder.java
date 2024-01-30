package hexlet.code;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferBuilder {
    public static String differ(Map<String, Object> dataOne, Map<String, Object> dataTwo) {
        Map<String, Object> result = new HashMap<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(dataOne.keySet());
        keys.addAll(dataTwo.keySet());
        for (String key: keys) {
            if (Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Unmodified
            } else if (!dataOne.containsKey(key)) {
                //Add data
            } else if (!dataTwo.containsKey(key)) {
                // Del
            } else if (!Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Update
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
