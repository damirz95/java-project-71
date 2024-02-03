package hexlet.code;

import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        //Pipe line
        //1 read file
        //2 pars data -> Map
        //3 нахождение разниц
        //4 Форматирование разницы в нужный формат(format)
        String contentOne = String.valueOf(Paths.get(path1));
        System.out.println(contentOne);
        String contentTwo = String.valueOf(Paths.get(path2));
        Map<String, Object> dataOne = Parser.parseJson(contentOne);
        Map<String, Object> dataTwo = Parser.parseJson(contentTwo);
        /*System.out.println(dataOne);
        System.out.println(dataTwo);*/
        return DifferBuilder.differ(dataOne, dataTwo);
    }
}
