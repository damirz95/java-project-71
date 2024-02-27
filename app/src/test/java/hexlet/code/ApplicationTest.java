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
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String resultPath = "src/test/resources/fixtures/resultStylish.txt";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testThreePlain() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String resultPath = "src/test/resources/fixtures/resultPlain.txt";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testFourDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        String resultPath = "src/test/resources/fixtures/resultStylish.txt";
        String result = readFixture(resultPath);
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
        String resultPath = "src/test/resources/fixtures/resultPlain.txt";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testSevenYamlStylish() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String resultPath = "src/test/resources/fixtures/resultStylish.txt";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println(actual);
        assertEquals(result, actual);
    }
    @Test
    public void testEightYamlDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        String resultPath = "src/test/resources/fixtures/resultStylish.txt";
        String result = readFixture(resultPath);
        var actual = Differ.generate(testPathOne, testPathTwo);
        System.out.println(actual);
        assertEquals(result, actual);
    }
}
