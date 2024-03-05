package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class ApplicationTest {
    //TODO yml, json -> plain,stylish,json, defoult;
    public static String readFixture(String fileName) throws IOException {
        return  Files.readString(Paths.get(fileName)).trim();
    }
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;


    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("src/test/resources/fixtures/result.json");
        resultPlain = readFixture("src/test/resources/fixtures/resultPlain.txt");
        resultStylish = readFixture("src/test/resources/fixtures/resultStylish.txt");
    }
    @Test
    public void testOneJson() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        var actual = Differ.generate(testPathOne, testPathTwo, "json");
        System.out.println(actual);
        assertEquals(resultJson, actual);
    }
    @Test
    public void testTwoStylish() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println("result");
        System.out.println(resultStylish);
        System.out.println("actual");
        System.out.println(actual);
        assertEquals(actual, resultStylish);
    }
    @Test
    public void testThreePlain() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(resultPlain, actual);
    }
    @Test
    public void testFourDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file1.json";
        String testPathTwo = "src/test/resources/fixtures/file2.json";
        var actual = Differ.generate(testPathOne, testPathTwo);
        System.out.println(actual);
        assertEquals(resultStylish, actual);
    }
    @Test
    public void testFiveYamlJson() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        var actual = Differ.generate(testPathOne, testPathTwo, "json");
        System.out.println(actual);
        assertEquals(resultJson, actual);
    }
    @Test
    public void testSixYamlPlain() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        var actual = Differ.generate(testPathOne, testPathTwo, "plain");
        System.out.println(actual);
        assertEquals(resultPlain, actual);
    }
    @Test
    public void testSevenYamlStylish() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        var actual = Differ.generate(testPathOne, testPathTwo, "stylish");
        System.out.println(actual);
        assertEquals(resultStylish, actual);
    }
    @Test
    public void testEightYamlDefault() throws Exception {
        String testPathOne = "src/test/resources/fixtures/file3.yml";
        String testPathTwo = "src/test/resources/fixtures/file4.yml";
        var actual = Differ.generate(testPathOne, testPathTwo);
        System.out.println(actual);
        assertEquals(resultStylish, actual);
    }
}
