package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class ApplicationTest {
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
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = "src/test/resources/fixtures/file1." + format;
        String filePath2 = "src/test/resources/fixtures/file2." + format;

        // Тестируем вызов метода с каждым из фоматерров, а также вызов с форматером по умолчанию
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(resultStylish);

        assertThat(Differ.generate(filePath1, filePath2, "stylish"))
                .isEqualTo(resultStylish);

        assertThat(Differ.generate(filePath1, filePath2, "plain"))
                .isEqualTo(resultPlain);

        String actualJson = Differ.generate(filePath1, filePath2, "json");
        JSONAssert.assertEquals(resultJson, actualJson, false);
    }
}
