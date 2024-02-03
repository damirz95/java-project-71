package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DifferBuilder {
    public static String differ(Map<String, Object> dataOne, Map<String, Object> dataTwo) {
        List<String> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(dataOne.keySet());
        keys.addAll(dataTwo.keySet());
        System.out.println(keys);
        for (String key: keys) {
            if (Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Unmodified
                result.add(" " + key+ ": " + dataOne.get(key));
            } else if (!dataOne.containsKey(key)) {
                //Add data
                result.add("+ " + key + ": " + dataTwo.get(key));
            } else if (!dataTwo.containsKey(key)) {
                //Del
                result.add("- " + key + ": " + dataOne.get(key));
            } else if (!Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                //Update
                result.add("- " + key+ ": " + dataOne.get(key));
                result.add("+ " + key+ ": " + dataTwo.get(key));
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
