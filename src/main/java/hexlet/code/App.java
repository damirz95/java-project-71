package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;


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
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
        return result;
    }

    public static void main (String[] args) {
        new CommandLine(new App()).execute(args);
    }
}