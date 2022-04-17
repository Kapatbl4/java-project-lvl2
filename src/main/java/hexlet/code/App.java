package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "Differ 1.0",
        description = "Compares two configuration files and shows a difference.")

public final class App implements Runnable {
    @Option(names = { "-f", "--format" }, description = "output format", defaultValue = "stylish",
            showDefaultValue = CommandLine.Help.Visibility.ALWAYS)
    private String format = "format";

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private static String firstFile;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private static String secondFile;

    @Override
    public void run() { // your business logic goes here...
    }
    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(Differ.generate(firstFile, secondFile));
        System.exit(exitCode);
    }
}
