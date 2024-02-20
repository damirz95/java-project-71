package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        //Pipe line
        //1 read file
        //2 pars data -> Map
        //3 нахождение разниц
        //4 Форматирование разницы в нужный формат(format)
        Map<String, Status> result =  DifferBuilder.differ(getData(path1), getData(path2));
        return Formatter.getFormattedText(result, format);
    }

    public static Map getData(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        String content = Files.readString(filePath);
        Map<String, Object> data = Parser.parse(content, getDataFormat(path));
        return data;
    }

    public static String getDataFormat(String filePath) throws Exception {
        String extention = "";
        if (filePath.indexOf(".") > 0) {
            extention = filePath.substring(filePath.indexOf(".") + 1);
        }
        return extention;
    }
}
