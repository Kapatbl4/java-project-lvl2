package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "Differ 1.0",
        description = "Compares two configuration files and shows a difference.")

public final class App implements Callable<String> {
    @Option(names = { "-f", "--format" }, description = "output format", defaultValue = "stylish",
            showDefaultValue = CommandLine.Help.Visibility.ALWAYS)
    private String format = "format";

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String firstFile;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String secondFile;

    @Override
    public String call() throws Exception { // your business logic goes here...
        System.out.println(Differ.generate(firstFile, secondFile));
        return (Differ.generate(firstFile, secondFile));
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
