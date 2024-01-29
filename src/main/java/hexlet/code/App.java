package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Command(name = "gendiff", version = "0.1", description = "Compares two configuration files and shows a difference.", mixinStandardHelpOptions = true)
public class App implements Callable {
    @Option(names = {"-f", "--format"}, description = "output format", defaultValue = "stylish")
    private String format;

    //"/home/damir/java-project-71/java-project-71/testfile"
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", description = "path to second file")
    private String filepath2;
    @Override
    public String call() throws Exception {
        Map<String, String> fileOne = getData(String.valueOf(Paths.get(filepath1)));
        Map<String, String> fileTwo = getData(String.valueOf(Paths.get(filepath2)));
        System.out.println(fileOne);
        System.out.println(fileTwo);
        Map<String, String> result = differ(fileOne, fileTwo);
        System.out.println(result);
        return "test";
    }
    public static Map<String, String> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> data = objectMapper.readValue( new URL("file:"+ content), new TypeReference<Map<String, String>>(){});
        return data;
    }
    public static Map<String, String> differ(Map<String, String> dataOne, Map<String, String> dataTwo) {
        Map<String, String> result = new HashMap<>();
        dataOne.forEach((key, value) -> {
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
        });


        return result;
    }
    public static void main (String[] args) {
        new CommandLine(new App()).execute(args);
    }
}