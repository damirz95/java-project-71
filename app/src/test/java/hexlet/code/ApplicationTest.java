package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void testOne() throws Exception {
        String testPathOne = "src/test/resources/file1.json";
        String testPathTwo = "src/test/resources/file2.json";
        String format = "";
        StringBuilder expected = new StringBuilder();
        expected.append("- follow: false\n");
        expected.append("  host: hexlet.io\n");
        expected.append("- proxy: 123.234.53.22\n");
        expected.append("- timeout: 50\n");
        expected.append("+ timeout: 20\n");
        expected.append("+ verbose: true\n");
        var actual = Differ.generate(testPathOne, testPathTwo, format);
        System.out.println(actual);
        assertEquals(expected.toString(), actual);
    }
    @Test
    public void testTwo() throws Exception {
        String testPathOne = "src/test/resources/file3.yml";
        String testPathTwo = "src/test/resources/file2.json";
        String format = "";
        StringBuilder expected = new StringBuilder();
        expected.append("- follow: false\n");
        expected.append("  host: hexlet.io\n");
        expected.append("- proxy: 123.234.53.22\n");
        expected.append("- timeout: 50\n");
        expected.append("+ timeout: 20\n");
        expected.append("+ verbose: true\n");
        var actual = Differ.generate(testPathOne, testPathTwo, format);
        System.out.println(actual);
        assertEquals(expected.toString(), actual);
    }
}
