package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {
    @Test
    public void testOne() throws Exception {
        String testPathOne = "src/test/resources/file1.json";
        String testPathTwo = "src/test/resources/file2.json";
        String format = "";
        List<String> expected = new ArrayList<>();
        expected.add("- follow: false");
        expected.add(" host: hexlet.io");
        expected.add("- proxy: 123.234.53.22");
        expected.add("- timeout: 50");
        expected.add("+ timeout: 20");
        expected.add("+ verbose: true");
        var actual = Differ.generate(testPathOne, testPathTwo, format);
        System.out.println(actual);
        assertEquals(expected.toString(), actual);
    }
    @Test
    public void testTwo() throws Exception {
        String testPathOne = "src/test/resources/file3.yml";
        String testPathTwo = "src/test/resources/file2.json";
        String format = "";
        List<String> expected = new ArrayList<>();
        expected.add("- follow: false");
        expected.add(" host: hexlet.io");
        expected.add("- proxy: 123.234.53.22");
        expected.add("- timeout: 50");
        expected.add("+ timeout: 20");
        expected.add("+ verbose: true");
        var actual = Differ.generate(testPathOne, testPathTwo, format);
        System.out.println(actual);
        assertEquals(expected.toString(), actual);
    }
}
