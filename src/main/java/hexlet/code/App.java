package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "Hello world 1.0",
        description = "Compares two configuration files and shows a difference.")
class HelloWorld implements Callable<String> {

  @Override
  public String call() throws Exception { // your business logic goes here...
    System.out.println("Hello world!");
    return "Hello world!";
  }

  // this example implements Callable, so parsing, error handling and handling user
  // requests for usage help or version help can be done with one line of code.
}
public class App {
  public static void main(String[] args) {
    int exitCode = new CommandLine(new HelloWorld()).execute(args);
    System.exit(exitCode);
  }
}
