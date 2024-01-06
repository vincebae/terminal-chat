package vincebae.chat.client;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import vincebae.chat.shared.message.SendRequest;

/** Entry point of the chat client application. */
@QuarkusMain
@Command(name = "terminal chat client", mixinStandardHelpOptions = true, version = "0.0.1")
public class AppRunner implements QuarkusApplication, Runnable {

  @Option(
      names = {"-n", "--name"},
      description = "Name")
  private String name;

  /** Entry point of Picocli. */
  @Override
  public void run() {
    System.out.println("Terminal chat client started.");
    System.out.println("Name: " + name);
    System.out.println("Terminal chat client stopping...");
    final var request = new SendRequest(name, "message");
    System.out.println("request: " + request);
  }

  /** Entry point of Quarkus Main. */
  @Override
  public int run(String... args) throws Exception {
    return new CommandLine(this).execute(args);
  }
}
