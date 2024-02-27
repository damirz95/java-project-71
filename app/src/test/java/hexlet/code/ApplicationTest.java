package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class ApplicationTest {
    //TODO yml, json -> plain,stylish,json, defoult;
    public static String readFixture(String fileName) throws IOException {
        return  Files.readString(Paths.get(fileName)).trim();
    }
    @Test
    public void testOneJson() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String resultPath = "src/test/resources/fixtures/result.json";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "json");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testTwoStylish() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String result = "- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n+ timeout: 20\n"
                + "+ verbose: true\n";
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testThreePlain() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file5.json";
        String testPathTwo = "src/test/resources/fixtures/file6.json";
        String result = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'\n";
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testFourDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String result = "- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n+ timeout: 20\n"
                + "+ verbose: true\n";
        var actual = Differ.generate(testPathOne, testPathTwo);
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testFiveYamlJson() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String resultPath = "src/test/resources/fixtures/result.json";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "json");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testSixYamlPlain() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String result = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true\n";
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testSevenYamlStylish() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String result = "- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n+ timeout: 20\n"
                + "+ verbose: true\n";
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testEightYamlDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String result = "- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n+ timeout: 20\n"
                + "+ verbose: true\n";
        var actual = Differ.generate(testPathOne, testPathTwo);
        System.out.println(actual);
        assertEquals(result, actual);
    }
}
